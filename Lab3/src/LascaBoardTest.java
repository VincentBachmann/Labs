import static org.junit.Assert.*;

import org.junit.Test;

public class LascaBoardTest
{

	@Test
	public void testLascaBoard()
	{
	
		LascaBoard board = new LascaBoard();
		
		if (board.getHeight() != 7 && board.getWidth() != 7)
		fail("Board is 7, 7 but got " + board.getHeight() + " " + board.getWidth());
	}

	@Test
	public void testGet()
	{
		
		LascaBoard board = new LascaBoard();
		
		
		char test = board.get(3, 3);
		
		
		
		if(test != 'V')
		fail("Test case is V but got " + test);
		
		

	}

	@Test
	public void testGetWidth() 
	{
	
		LascaBoard board = new LascaBoard();
		
		int test = board.getWidth();
		
		if(test != 7)
		fail("Board has a width of 7 but got " + board.getWidth());
	}

	@Test
	public void testGetHeight() 
	{
		
		LascaBoard board = new LascaBoard(7, 7);
		
		int test = board.getHeight();
		
		if(test != 7)
		fail("Board has a height of 7 but got " + board.getHeight());
	}

	@Test
	public void testSet() 
	{
		
		LascaBoard board = new LascaBoard();
		
		board.set(7, 7, 'V');
		
		if(board.get(7, 7) != 'V')
		fail("Failed to get board V");
	}

	@Test
	public void testshowQueue() 
	{
		
		LascaBoard board = new LascaBoard();
		board.set(7, 7, 'V');
		board.set(7, 7, 'L');
		board.set(7, 7, 'B');
		
		String test1 = board.showQueue(0, 0);
		
		if (!test1.equals("[V, L, B]"))
		fail("The Queue should have contained [V, L, B] but has " + test1);
	}

	@Test
	public void testMove() 
	{
		
		LascaBoard board = new LascaBoard();
		board.set(3, 3, 'R');
		board.set(2, 2, 'B');
		board.set(2, 2, 'G');
		board.set(2, 2, 'R');
		board.set(3, 5, 'R');
		board.set(4, 4, 'F');
		board.clearContents(5, 3);
		
		boolean test1 = board.changeMove(2, 0, 1);
		boolean test2 = board.changeMove(1, 1, 1);
		
		
		if (test1 != false)
		fail("Test failed" + test1);
		
		if (test2 != false) 
		fail("Test failed " + test2);
		
		
	}

	@Test
	public void testemptyQueueTransfer() 
	{
		
		LascaBoard board = new LascaBoard();
		board.set(0, 0, 'V');
		board.set(0, 0, 'V');
		board.set(0, 0, 'V');
		board.set(0, 0, 'V');
		
		board.emptyQueueTransfer(0, 0, 0, 1);
		
		if(!board.showQueue(0, 1).equals("[R, R, R, R, R]"))
		fail("The queue is V but got " + (board.showQueue(0, 1)));
	}
	
	@Test
	public void testcheckWinnerR() 
	{
		
		LascaBoard board = new LascaBoard();
		for(int i = 0; i < board.getHeight(); i++) 
		{
			for(int j = 0; j < board.getWidth(); j++) 
			{
				if (board.get(i, j) == null) 
				{
					
				}
				else if (board.get(i, j) == 'R') 
				{
					board.clearContents(i, j);
				}
			}
		}
		
		boolean test = board.checkWinner();
		
		if (test != true)
		fail("Red pieces are gone but got" + test);
	}
	
	@Test
	public void testcheckWinnerB() 
	{
		
		LascaBoard board = new LascaBoard();
		for(int i = 0; i < board.getHeight(); i++) 
		{
			for(int j = 0; j < board.getWidth(); j++)
			{
				if (board.get(i, j) == null) 
				{
					
				}
				else if (board.get(i, j) == 'B') 
				{
					board.clearContents(i, j);
				}
			}
		}
		
		boolean test = board.checkWinner();
		
		if (test != true)
		fail("Black pieces are gone but got" + test);
	}
	
	
	
	@Test
	public void testchangeMove()
	{
		
		LascaBoard board = new LascaBoard();
		for(int i = 0; i < board.getHeight(); i++)
		{
			for(int j = 0; j < board.getWidth(); j++)
			{
				if (board.get(i, j) == null)
				{
					
				}
				else if (board.get(i, j) == 'B' || board.get(i,j) == 'R')
				{
					board.clearContents(i, j);
				}
			}
		}
		board.set(1, 1, 'R');
		board.set(1, 5, 'B');
		board.set(5, 1, 'B');
		board.set(5, 5, 'R');
		
		boolean test = board.changeMove(1, 1, 7);
		boolean test2 = board.changeMove(1, 5, 9);
		boolean test3 = board.changeMove(5, 1, 1);
		boolean test4 = board.changeMove(5, 5, 3);
		
		if(test != true)
		fail("Moved up and left and failed");
		
		if (test2 != true)
		fail("Moved up and right and failed");
		
		if(test3 != true)
		fail("Moved down and left and failed");
		
		if(test4 != true)
		fail("Moved down and right and failed");
	}
	
	
	@Test
	public void testcheckHasMoves()
	{
		
		LascaBoard board = new LascaBoard();
		for(int i = 0; i < board.getHeight(); i++) 
		{
			for(int a = 0; a < board.getWidth(); a++) 
			{
				if (board.get(i, a) == null)
				{
					
				}
				else if (board.get(i , a) == 'B' || board.get(i,a) == 'R')
				{
					board.clearContents(i, a);
					board.set(i, a, 'B');
					board.clearContents(1, 1);
					board.set(1, 1, 'R');
					board.set(3, 3, 'R');
				}
			}
		}
		
		boolean test1 = board.checkHasMoves(board, 0);
		boolean test2 = board.checkHasMoves(board, 1);
		
		
		if(test1 != false)
		fail("Could not jump" + test1);
		
		if(test2 != true)
		fail("Board piece should move");
		
	}
}
	
	