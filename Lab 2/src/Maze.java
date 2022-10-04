
public class Maze
{
	private int width;
	private int height;
	private char [][] maze;
	
	public Maze(int width, int height)
	{
		this.width = width;
		this.height = height;
		maze = new char [width][height];
		
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void set(char character, int row, int column)
	{
		maze[row][column] = character;
	}
	
	
	public char get(int row, int column)
	{
		return maze[row][height];
		
	}
	
	public String solve(int firstRow, int firstCol, int lastRow, int lastCol, String direction)
	{
		String result = "";
		String previousDirection = direction;
		
		firstRow = '*';
		lastRow = '*';
		
		if (firstRow == lastRow && firstCol == lastCol) 
		{
			result = lastRow + "," + lastCol;
			return result;
		}
		if (countdirections(firstRow, firstCol) == 0) 
		{
			return null;
		}
		if (countdirections(firstRow, firstCol) == 1) 
		{
			if (get(firstRow + 1, firstCol) == ' ') 
			{
				String changedDirection = "South";
				if (previousDirection == null) 
				{
					return solve((firstRow + 1), firstCol, lastRow, lastCol, changedDirection);
				}
				else if (previousDirection.equals("South")) 
				{
					return solve((firstRow + 1), firstCol, lastRow, lastCol, changedDirection);
				}
				else {
					int southRow = firstRow + 1;
					int southCol = firstCol;
					result = solve(southRow, southCol, lastRow, lastCol, changedDirection);
					if (result != null) {
						return firstRow + "," + firstCol + "-" + result;
					}
				}
			} 
			else if (get((firstRow - 1), firstCol) == ' ') 
			{
				if (get(firstRow - 1, firstCol) == ' ') 
				{
					String changedDirection = "North";
					if (previousDirection == null) 
					{
						return solve((firstRow - 1), firstCol, lastRow, lastCol, changedDirection);
					} else if (previousDirection.equals("North")) {
						return solve((firstRow - 1), firstCol, lastRow, lastCol, changedDirection);
					} else 
					{
						int northRow = firstRow - 1;
						int northCol = firstCol;
						result = solve(northRow, northCol, lastRow, lastCol, changedDirection);
						if (result != null) 
						{
							return firstRow + "," + firstCol + "-" + result;
						}
					}
				}
			} else if (get(firstRow, (firstCol + 1)) == ' ') 
			{
				if (get(firstRow, (firstCol + 1)) == ' ') 
				{
					String changedDirection = "East";
					if (previousDirection == null)
					{
						return solve(firstRow, firstCol + 1, lastRow, lastCol, changedDirection);
					} else if (previousDirection.equals("East"))
					{										
						return solve(firstRow, firstCol + 1, lastRow, lastCol, changedDirection);
					} else 
					{
						int eastRow = firstRow;
						int eastCol = firstCol + 1;
						result = solve(eastRow, eastCol, lastRow, lastCol, changedDirection);
						if (result != null)
						{
							return firstRow + "," + firstCol + "-" + result;
						}
					}
				}
			}
			else if (get(firstRow, (firstCol - 1)) == ' ') 
			{
				if (get(firstRow, firstCol - 1) == ' ')
				{
					String changedDirection = "West";
					if (previousDirection == null) 
					{
						return solve(firstRow, firstCol - 1, lastRow, lastCol, changedDirection);
					} 
					else if (previousDirection.equals("West")) {
						return solve(firstRow, firstCol - 1, lastRow, lastCol, changedDirection);
					}
					else
					{
						int westRow = firstRow;
						int westCol = firstCol - 1;
						result = solve(westRow, westCol, lastRow, lastCol, changedDirection);
						if (result != null) {
							return firstRow + "," + firstCol + "-" + result;
						}
					}
				}
			}
		}
		

		
		if (get(firstRow, firstCol + 1) == ' ') 
		{
			String changedDirection = "East";
			int eastRow = firstRow;
			int eastCol = firstCol + 1;
			result = solve(eastRow, eastCol, lastRow, lastCol, changedDirection);
			if (result != null) 
			{
				return firstRow + "," + firstCol + "-" + result;
			}
		}
		
		if (get(firstRow + 1, firstCol) == ' ') 
		{
			String changedDirection = "South";
			int southtRow = firstRow + 1;
			int southCol = firstCol;
			result = solve(southtRow, southCol, lastRow, lastCol, changedDirection);
			if (result != null) 
			{
				return firstRow + "," + firstCol + "-" + result;
			}
		}
		
		if (get(firstRow, firstCol - 1) == ' ') 
		{
			String changedDirection = "West";
			int westRow = firstRow;
			int westCol = firstCol - 1;
			result = solve(westRow, westCol, lastRow, lastCol, changedDirection);
			if (result != null) 
			{
				return firstRow + "," + firstCol + "-" + result;
			}
		}
		
		if (get(firstRow - 1, firstCol) == ' ') 
		{
			String changedDirection = "North";
			int northRow = firstRow - 1;
			int northCol = firstCol;
			result = solve(northRow, northCol, lastRow, lastCol, changedDirection);
			if (result != null) 
			{
				return firstRow + "," + firstCol + "-" + result;
			}
		}
		return null;

		
	}
	private int countdirections(int currentrow, int currentcol) 
	{
		int directions = 0;
		if (get((currentrow + 1), currentcol) == ' ')
		{
			directions++;
		}
		if (get((currentrow - 1), currentcol) == ' ') 
		{
			directions++;
		}
		if (get(currentrow, (currentcol + 1)) == ' ') 
		{
			directions++;
		}
		if (get(currentrow, (currentcol - 1)) == ' ') 
		{
			directions++;
		}
		return directions;
	}
	

	public void resetMaze() 
	{
		int height = getHeight();
		int width = getWidth();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (get(i, j) == '*') {
					set(' ', i, j);
				}
			}
		}
	}

	public int Available() {
		// TODO Auto-generated method stub
		return 0;
	}
}


