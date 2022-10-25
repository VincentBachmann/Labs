import java.util.LinkedList;
import java.util.Queue;

public class LascaBoard 
{
	private String board[][];
	
	public LascaBoard() 
	{
		createBoard(7,7);	
	}
	
	public LascaBoard(int height, int width) 
	{
		createBoard(height,width);
	}
	
	public Character get(int row, int column) 
	{
		if (row < 0 || row >= board.length || column < 0 || column >= board[0].length)
				return null;
		return board[row][column].playerPeek();
	}
	
	public int getWidth() 
	{
		return board[0].length;
	}

	public int getHeight() 
	{
		return board.length;
	}
	
	public String showQueue(int row, int column) 
	{
		LinkedList<Character> peekQueue = new LinkedList<Character>();
		String q = peekQueue.toString();
		return q;
	}
	
	public void set(int row, int column, char newcharacter) 
	{
		board[row][column].add(newcharacter);
	}
	
	public void clearContents(int row, int column)
	{
		board[row][column].clear();
	}
	
	public boolean checkWinner() 
	{
		boolean hasRed = false;
		boolean hasBlack = false;
		for (int i = 0; i < getWidth(); i++) 
		{
			for (int j = 0; j < getHeight(); j++) 
			{
				if (get(i, j) == null) 
				{

				} else if (get(i, j) == 'R') 
				{
					hasRed = true;
				}
				else if (get(i, j) == 'B') 
				{
					hasBlack = true;
				}
			}
		}
		if (hasRed == true && hasBlack == true) 
		{
			return false;
		} 
		else 
		{
			return true;
		}
	}
	
	public boolean move(int row, int column, int nextrow, int nextcol, int jumprow, int jumpcol) 
	{
		
		if (nextrow >= getHeight() || nextrow < 0 || nextcol < 0 || nextcol >= getWidth()) 
		{
			return false;
		}
		
		else if (board[nextrow][nextcol].peek() == board[row][column].peek()) 
		{
			return false;
		}
		
		else if (board[nextrow][nextcol].isEmpty() == true)
		{
			emptyQueueTransfer(row, column, nextrow, nextcol);
			return true;
		}
		
		else if (board[nextrow][nextcol].peek() != board[row][column].peek()) 
		{
			
			if (jumprow >= getHeight() || jumprow < 0 || jumpcol < 0 || jumpcol >= getWidth()) {
				return false;
			}
			
			else if (board[jumprow][jumpcol].isEmpty()) 
			{
				
				emptyQueueTransfer(row, column, jumprow, jumpcol);
				char transfer = board[nextrow][nextcol].poll();
				set(jumprow, jumpcol, transfer);
				return true;
			} else if (board[jumprow][jumpcol].peek() == 'R' || board[jumprow][jumpcol].peek() == 'B') 
			{
				return false;
			}
		}
		return false;
	}
	
	public boolean changeMove(int row1, int col1, int move) 
	{
		int row = row1;
		int col = col1;
		if (move == 1) 
		{
			int nextrow = row + 1;
			int nextcol = col - 1;
			int jumprow = row + 2;
			int jumpcol = col - 2;
			boolean result = move(row, col, nextrow, nextcol, jumprow, jumpcol);
			return result;
		} 
		else if (move == 3) 
		{
			int nextrow = row + 1;
			int nextcol = col + 1;
			int jumprow = row + 2;
			int jumpcol = col + 2;
			boolean result = move(row, col, nextrow, nextcol, jumprow, jumpcol);
			return result;
		} 
		else if (move == 7) 
		{
			int nextrow = row - 1;
			int nextcol = col - 1;
			int jumprow = row - 2;
			int jumpcol = col - 2;
			boolean result = move(row, col, nextrow, nextcol, jumprow, jumpcol);
			return result;
		} 
		else if (move == 9) 
		{
			int nextrow = row - 1;
			int nextcol = col + 1;
			int jumprow = row - 2;
			int jumpcol = col + 2;
			boolean result = move(row, col, nextrow, nextcol, jumprow, jumpcol);
			return result;
		}
		return false;
	}
	
	public void emptyQueueTransfer(int startrow, int startcol, int endrow, int endcol) 
	{
		while (!board[startrow][startcol].isEmpty()) 
		{
			char transfer = board[startrow][startcol].poll();
			board[endrow][endcol].add(transfer);
		}
	}
	
	private void createBoard(int height, int width) 
	{
		// TODO Auto-generated method stub
		board = new Queue[height][width];
		for (int i = 0; i < height; i++) 
		{
			for (int j = 0; j < width; j++) 
			{
				board[i][j] = new Board();

			}
		}
		setRed();
		setBlack();
	}
	
	private void setRed()
	{
		for (int i = 0; i < 3; i = i + 2)
		{
			for (int j = 0; j < board.length; j = j + 2)
			{
				
				board[i][j].add('R');
			}
		}
		for (int l = 1; l < board.length; l = l + 2)
		{
			
			board[1][l].add('R');
		}
	}
	
	private void setBlack() 
	{
		for (int i = (getHeight() - 3); i < getHeight(); i = i + 2)
		{
			for (int j = 0; j < board.length; j = j + 2) 
			{
				
				board[i][j].add('B');
			}
		}
		for (int l = 1; l < board.length; l = l + 2) 
		{
			int secondLastRow = (getHeight() - 2);
			
			board[secondLastRow][l].add('B');
		}
	}
	
	public boolean checkHasMoves(LascaBoard board2, int player) 
	{
		// TODO Auto-generated method stub
		int currentPlayer = player;
		char target = ' ';
		char other = ' ';
		if (currentPlayer == 0) 
		{
			target = 'R';
			other = 'B';
		} 
		else if (currentPlayer == 1) 
		{
			target = 'B';
			other = 'R';
		}

		for (int i = 0; i < getHeight(); i++)
		{
			for (int j = 0; j < getWidth(); j++) 
			{

				
				if (board[i][j].isEmpty()) 
				{

				}
				else if (board[i][j].peek() == target) {
					if ((i - 1) < 0 || (j - 1) < 0 || i > (getHeight() - 1) || j > (getWidth() - 1)) 
					{ 

					} 
					else if (board[i - 1][j - 1].isEmpty()) 
					{
						return true;
					} 
					else if (board[i - 1][j - 1].peek() == target)
					{

					} 
					else if (board[i - 1][j - 1].peek() == other) 
					{
						if ((i - 2) < 0 || (j - 2) < 0) {

						} 
						else if (board[i - 2][j - 2].isEmpty()) 
						{
							return true;
						} 
						else if (board[i - 2][j - 2].peek() == target || board[i - 2][j - 2].peek() == other) 
						{

						}
					}
				}



				if (board[i][j].isEmpty()) 
				{

				} 
				else if (board[i][j].peek() == target) 
				{
					if ((i - 1) < 0 || (j + 1) > (getWidth() - 1)) 
					{
					} 
					else if (board[i - 1][j + 1].isEmpty()) 
					{
						return true;
					} 
					else if (board[i - 1][j + 1].peek() == target) 
					{

					} 
					else if (board[i - 1][j + 1].peek() == other) 
					{
						if ((i - 2) < 0 || (j + 2) > (getWidth() - 1)) 
						{

						}
						else if (board[i - 2][j + 2].isEmpty()) 
						{
							return true;
						}
						else if (board[i - 2][j + 2].peek() == target || board[i - 2][j + 2].peek() == other) 
						{

						}
					}
				}

				
				if (board[i][j].isEmpty()) 
				{

				}
				else if (board[i][j].peek() == target) 
				{
					if ((i + 1) > (getHeight() - 1) || (j - 1) < 0) { 

					} 
					else if (board[i + 1][j - 1].isEmpty()) 
					{
						return true;
					} 
					else if (board[i + 1][j - 1].peek() == target) 
					{

					} 
					else if (board[i + 1][j - 1].peek() == other)
					{
						if ((i + 2) > (getHeight() - 1) || (j - 2) < 0)
						{

						} 
						else if (board[i + 2][j - 2].isEmpty())
						{
							return true;
						} 
						else if (board[i + 2][j - 2].peek() == target || board[i + 2][j - 2].peek() == other) {

						}
					}
				}

				if (board[i][j].isEmpty()) 
				{

				} else if (board[i][j].peek() == target) 
				{
					if ((i + 1) > (getHeight() - 1) || (j + 1) > (getWidth() - 1)) 
					{ 

					} 
					else if (board[i + 1][j + 1].isEmpty()) 
					{
						return true;
					} 
					else if (board[i + 1][j + 1].peek() == target) 
					{

					} 
					else if (board[i + 1][j + 1].peek() == other)
					{
						if ((i + 2) > (getHeight() - 1) || (j + 2) > (getWidth() - 1)) 
						{

						} 
						else if (board[i + 2][j + 2].isEmpty()) 
						{
							return true;
						} 
						else if (board[i + 2][j + 2].peek() == target || board[i + 2][j + 2].peek() == other) 
						{

						}
					}
				}
			}
		}
		return false;
	}

	public boolean adjustMove(int row, int col, int move) {
		
		return false;
	}
}