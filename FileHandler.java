package employee_detail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    public static String[] readAndStoreInArray(String fileName)
    {
        ArrayList<String> lines = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while((line = br.readLine()) !=null)
            {
                lines.add(line);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.err.println("An Error Occured ");
        }
        return lines.toArray(new String[0]);
    }
    
    public static File readAndReturnFile(String fileName)
    {
        File myFile = new File(fileName);
        try
        {
            if(myFile.createNewFile())
            {
                System.out.println("File Created Successfully :"+ myFile.getName());
            }
            else
            {
                System.out.println("File Already Exists!");
            }
        }
        catch(IOException ex)
        {
            System.out.println("Error occured when creating file!");
        }
        return myFile;
    }
    
    public static boolean checkValues(String fileName, String value)
    {
        boolean found = false;
        File myFile = new File(fileName);
        try
        {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String FindLine;
            outerLoop:
            while(null!= (FindLine = bufferedReader.readLine()))
            {
                if(FindLine.equals(value))
                {
                    found = true;
                }
            }
        }
        catch(IOException ex)
        {
            System.out.println("An Error occured when Searching! "+ ex);
        }
        return found;
    }
    
    public static boolean checkValuesHR(String value)
    {
        boolean found = false;
        File myFile = new File("src\\employee_detail\\Sources\\HR_Logins.txt");
        try
        {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String FindLine;
            outerLoop:
            while(null!= (FindLine = bufferedReader.readLine()))
            {
                String UserName = FindLine.split("__")[0];
                if(UserName.equals(value))
                {
                    found = true;
                }
            }
        }
        catch(IOException ex)
        {
            System.out.println("An Error occured when Searching! "+ ex);
        }
        return found;
    }
    
}
