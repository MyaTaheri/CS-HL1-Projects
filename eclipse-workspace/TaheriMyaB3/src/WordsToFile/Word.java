package WordsToFile;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

//This class is the blueprint for all words
public class Word 
{
    //Global Variables:
    private String word;

    //Constructor
    public Word()
    {
        setWord();
        writeWordToFile();
    }

    public void setWord()
    {
        Scanner scnr = new Scanner (System.in);
        System.out.println("Enter in your first name");
        word = scnr.next();
        scnr.close();
    }

    public void writeWordToFile()
    {
        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter(new FileOutputStream("first.txt", true));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Err 404: File Not Found");
            System.exit(0);
        }
        System.out.println("I am writing to a file for you.");
        outputStream.println("first Name: ");
        outputStream.println(word);
        outputStream.close();
    }

}
