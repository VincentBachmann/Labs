import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class MazeController {
	
		private File userFile;
		PrintWriter output = null;
	public static void main(String[] args)
	{
		MazeController controller = new MazeController();
		controller.go();
	}
	private List<Integer> coordinates = new ArrayList<Integer>();
	
	public void go()
	{
		Maze maze = readMazeFromFile(maze);
		
		
	
		Maze path = new Maze(7, 4);
		
		while (!((CharSequence) maze).isEmpty()) {
			MazeSpot startRow = MazeSpot.Available;
			int startCol = maze.Available();
			path.resetMaze();
			String result = solvemaze((MazeCoordinates) coordinates, maze);
			if (result == null) {
				output.println("Impossible");
			} else {
				output.print(startRow + "," + startCol + "-");
				printResult(result);
			}
		}
		outputClose();
			//Read maze from file
			
			//for each start and end pair
			//{
			//   solve the maze. result = maze.solve(startRow, startCol, endRow, endCol)
			//   output the answer
			//}
		}
	
	public Maze readMazeFromFile(Maze maze)
	{
		File file = getMazeFileFromUser();
	
		
		int width = maze.getWidth();
		int height = maze.getHeight();
		char character = 0;
		Maze maze1 = new Maze(width, height);
		
		for (int row = 0; row < height; row++)
			for (int column = 0; column < width; column++)
				
				maze1.set(character, row, column);
		
		//while we have start and end coordinates, can be done with scanner.hasnext
		//{
		//	read start coordinates and add them to the list
		// read end coordinates and add them to the list
		//}
		
		//close scanner
		return maze1;
		
		
	}
	public File getMazeFileFromUser()
	{
		
		JFileChooser chooser = new JFileChooser();
		
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			
			Scanner input = null;
			
			try {
			input = new Scanner(file);
			} catch (FileNotFoundException e)
			{
				System.out.println("Could not find the file" + file.getName());
				return file;
			}
			input.close();
			
			
		}
		return userFile;
		
	}
	private String solvemaze(MazeCoordinates cords, Maze maze) 
	{
		String result = maze.solve(cords.getStartRow(), cords.getStartColumn(), cords.getEndRow(),
				cords.getEndColumn(), null);
		return result;
	}

	
	private void outputClose() {
		output.close();
	}

	private void printResult(String result) {
		output.print(result);
		output.println();
	}

	public List<Integer> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Integer> coordinates) {
		this.coordinates = coordinates;
	}
	
}
	
	
	
