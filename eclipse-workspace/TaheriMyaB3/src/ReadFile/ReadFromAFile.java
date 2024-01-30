package ReadFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromAFile 
{
    public static void main (String[] args)
    {
        System.out.println("read from a file");
        Scanner scnr = null;

        try
        {
            File file = new File ("/Users/mt25190/Desktop/CS-HL1-Projects/eclipse-workspace/TaheriMyaB3/sleepHours.txt");
            scnr = new Scanner(new FileInputStream(file));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("error! - file not found");
            System.exit(0);
        }
        int sleep1 = scnr.nextInt();
        int sleep2 = scnr.nextInt();
        int sleep3 = scnr.nextInt();
        int sleep4 = scnr.nextInt();
        double avg = (sleep1 + sleep2 + sleep3 + sleep4)/4.0;
        System.out.println("Sleep avg: " + avg);

        scnr.close();
        

    }
    
}
