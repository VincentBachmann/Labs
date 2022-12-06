import org.junit.Test;

public class ViewTest 
{
    
    public void testAskForFile() 
    {
        View view = new View();
        view.askForFile();
    }

    @Test
    public void testDisplayResult() 
    {
        View view = new View();
        view.Result(true);
        view.Result(false);
    }

    
}