package GeorgraphyQuiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromAFile 
{
    public static String ReadLine(File file)
    {
        System.out.println("read from a file");
        Scanner scnr = null;

        try
        {
            scnr = new Scanner(new FileInputStream(file));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("error! - file not found");
            System.exit(0);
        }
        String line = scnr.nextLine();
        System.out.println("State: " + line);
        scnr.close();

        return line;
    }
    
}
