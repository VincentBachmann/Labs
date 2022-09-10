import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplayController 
{
	public static void main(String[] args)
	{
		ReplayController controller = new ReplayController();
		controller.go();
	}
	public void go()
	{
		IsolaBoard board = new IsolaBoard ();
		IsolaBoardView view = new IsolaBoardView (board);
		PrintWriter p = File();
		view.display();
		BoardSpace currentplayer = BoardSpace.Player1;
		view.display();
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		
		BoardPosition currentPosition = board.findPosition(currentplayer);
		int row = currentPosition.getRow();
		int column = currentPosition.getColumn();
		
		if (input.equalsIgnoreCase("W"))
		{
			row = row-1;
			System.out.println("North");
		}
		else if (input.equalsIgnoreCase("A"))
		{
			column = column-1;
			System.out.print("West");
		}
		else if (input.equalsIgnoreCase("S"))
		{
			column = column+1;
			System.out.print("South");
		}
		else if (input.equalsIgnoreCase("D"))
		{
			row = row+1;
			System.out.print("East");
		}
		else if (input.equalsIgnoreCase("WA"))
		{
			column = column-1;
			System.out.print("North West");
		}
		else if (input.equalsIgnoreCase("WD"))
		{
			column = column+1;
			System.out.print("North East");
		}
		else if (input.equalsIgnoreCase("SA"))
		{
			row = row+1;
			System.out.print("South West");
		}
		else if (input.equalsIgnoreCase("SD"))
		{
			row = row+1;
			System.out.print("South East");
		}
		
		
		BoardPosition swap = new BoardPosition(row,column);
		board.movePlayer(currentplayer, swap);
		
		BoardPosition position = board.findPosition(currentplayer);
		
		if (currentplayer == BoardSpace.Player1)
		{
			currentplayer = BoardSpace.Player2;
		}
		else
		{
			currentplayer = BoardSpace.Player1;
		}
				
	}
		public PrintWriter File()
		{
			File writer = new File("writer.dat");
			PrintWriter output = null;
			
			try {
				output = new PrintWriter(writer);
					return output;
			
			}
			catch (FileNotFoundException e) {
				System.out.println("File wasn't created");
				return null;
			}
			try
			 {
				 
				// Sleep time is in milliseconds
				 Thread.sleep(seconds*1000);
				 } catch (Exception e)
				 {
				 // This should never happen
				 }
			
		
		
		
	}
}
