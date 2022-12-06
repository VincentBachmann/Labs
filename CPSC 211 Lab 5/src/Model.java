import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Model 
{
    private int numberOfSpaces;
    private int[][] adj_matrix;

    public Model(File file) 
    {
        try 
        {
            try (Scanner scan = new Scanner(file)) {
				numberOfSpaces = scan.nextInt();
				System.out.println("Number of spaces: " + numberOfSpaces);
				scan.nextLine(); // Gets scanner ready for next line.
				adj_matrix = new int[numberOfSpaces][numberOfSpaces];
				for (int i=0; i < numberOfSpaces; i++) 
				{
				    String line = scan.nextLine();
				    System.out.print("Space " + i + ": ");
				    System.out.println(line);
				    String[] inputs = line.split(" ");
				    for (int j=0; j < inputs.length; j++) 
				    {
				        adj_matrix[i][j] = Integer.parseInt(inputs[j]);
				    }
				}
			}
        } catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
    }

    public boolean isConnected(int startingNode)
    {
        boolean[] visited = new boolean[numberOfSpaces];
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(startingNode);
        visited[startingNode] = true;
        while (!queue.isEmpty()) 
        {
            int currentNode = queue.remove(0);
            for (int i=0; i < numberOfSpaces; i++) 
            {
                if (adj_matrix[currentNode][i] == 1 && !visited[i]) 
                {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        for (int i=0; i < numberOfSpaces; i++) 
        {
            if (!visited[i])
            {
                return false;
            }
        }
        return true;
    }
}