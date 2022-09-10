
public class IsolaBoardView {
	IsolaBoard board;
	
	public IsolaBoardView (IsolaBoard b)
	{
		board = b;
	}
	
	public void display()
	{	
		for (int row = 0; row < 7; row++) {
            for (int column = 0; column <  7; column++) { 
            	
            	BoardSpace u = board.get(row, column); 
            	if (u == BoardSpace.Player1) {
            		System.out.println("X");
            	}
            	if (u == BoardSpace.Player2) {
            		System.out.println("O");
            	}
            	
            	if (u == BoardSpace.Available) {
            		System.out.println("-");
            	}
            	else {
            		System.out.println(" ");
            	}
            System.out.println();
            	}
            }
            
          
            	
          	
            	
		}
}



