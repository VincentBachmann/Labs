import java.io.File;

import javax.swing.JFileChooser;

public class Controller 
{
    public static void main(String[] args) 
    {
    	
        Controller controller = new Controller();
        controller.go();
    }

    private void go() 
    {
        View view = new View();
        
        view.askForFile();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File dir = fileChooser.getSelectedFile();
            String path = dir.getAbsolutePath();

           
            File[] files = new File(path).listFiles();
            for (File file : files) 
            {
                if (file.getName().endsWith(".txt")) 
                {
                    Model board = new Model(file);
                    
                    boolean isPossible = board.isConnected(0);
                    view.Result(isPossible);
                }
            }
        }
        else 
        {
            return;
        }

        
    }
}