import java.io.File;
import org.junit.Test;

public class ModelTest 
{
    @Test
    public void testIsConnected() 
    {
        Model board = new Model(new File("test.txt"));
        if (board.isConnected = false)
        	System.out.print(false);
        if (board.isConnected = true)
        	System.out.print(true);
    }
}