public class View {
   
    public void askForFile() 
    {
        System.out.println("Select a board file");
        
    }

    public void Result(boolean isPossible)
    {
        
        if (isPossible) 
        {
            System.out.println("This board is possible");
        } 
        else 
        {
            System.out.println("This board is impossible");
            
        }
    }


}