import static org.junit.Assert.*;

import org.junit.Test;

public class MazeTest 
{

	@Test
	public void testMaze() 
	{
		int mazeHeight = 7;
		int mazeWidth = 4;
		
		Maze maze = new Maze(mazeWidth, mazeHeight);
		int heightTest = maze.getHeight();
		int widthTest = maze.getWidth();
		
		if (widthTest != 4 && heightTest != 7)
			fail("The width is 4 but got " + maze.getWidth() + 
				" The height is 7 but got" + maze.getHeight());
	}
	public void testGetWidth() 
	{
		
		int mazeHeight = 7;
		int mazeWidth = 4;
		Maze maze = new Maze(mazeWidth, mazeHeight);
		
		int test = maze.getWidth();
		
		if (test != 4)
			fail("Maze width is 4 but got " + maze.getWidth());
	}

	@Test
	public void testGetHeight()
	{
		
		int mazeHeight = 7;
		int mazeWidth = 4;
		Maze maze = new Maze(mazeWidth, mazeHeight);
		
		int test = maze.getHeight();
		
		if (test != 7)
			fail("Maze height is 7 but got " + maze.getHeight());
	}
	@Test
	public void testSolve() {

		int mazeH = 10;
		int mazeW = 10;
		Maze maze = new Maze(mazeW, mazeH);
		for(int i = 0; i < maze.getWidth(); i ++) {
			for(int j = 0; j < maze.getHeight(); j ++) {
				maze.set('#', i, j);
			}
		}
		
		String result = maze.solve(1, 1, 1, 5, null);
		maze.resetMaze();
		String result2 = maze.solve(1, 5, 1, 1, null);
		maze.resetMaze();
		String result3 = maze.solve(1, 1, 6, 8, null);
		//Validation
		if (! result.equals("1,3-4,3-5,3-5,5-8,5-8,7-4,7-4,8-2,8-2,5-1,5"))
		fail("String did not report correct moves to Solve Maze");
		if (!result2.equals("2,5-2,8-4,8-4,7-8,7-8,5-5,5-5,3-4,3-1,3-1,1"))
		fail("String2 did not report correct move to Solve Maze");	
		if (result3 != null)
		fail("Tried to Solve A Non Maze Coordinate and Got Something Else");

}
}
