package GeorgraphyQuiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.print.DocFlavor.URL;
import javax.swing.*;
import java.awt.*;

public class GeographyGui extends JFrame implements ActionListener
{
    private File file = new File ("/Users/mt25190/Desktop/CS-HL1-Projects/geography.txt");
    private JTextField stateField;
    private JLabel questionLabel;
	private JLabel capitalLabel;
	private JTextField capitalField;
    private JLabel resultLabel;
    static Scanner scnr = null;
    private int correct = 0;
    String state = "United States";
    String capital = "Washington DC";
    
    public GeographyGui()
    {
        super("GeographyGui");		
        setSize(450,650);
        this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);


        Color backgroundColor = new Color(215, 210, 250);
        Color fontColor = new Color(35, 15, 135);
        getContentPane().setBackground(backgroundColor);

		questionLabel = new JLabel("What is the capital of United States");
            questionLabel.setBounds(40, 40, 400, 50);
            questionLabel.setForeground(fontColor);
            questionLabel.setFont(new Font("Ink Free", Font.PLAIN, 20));
            add(questionLabel);
		JLabel stateLabel = new JLabel("State/Country:");
             stateLabel.setBounds(40, 140, 200, 50);
			add(stateLabel);
        stateField = new JTextField("state for new question", 25);
            stateField.setBounds(250,140,150, 50);
			add(stateField);
		JLabel capitalLabel = new JLabel("Enter Capital:");
            capitalLabel.setBounds(40, 240, 200, 50);
			add(capitalLabel);
        capitalField = new JTextField("capital", 25);
            capitalField.setBounds(250,240,150, 50);
			add(capitalField);
		JButton checkButton = new JButton("Check");
            checkButton.setBounds(40,340,75,50);
            checkButton.addActionListener(this);
			add(checkButton);
        JButton questionButton = new JButton("Add Question");
            questionButton.setBounds(250, 340,150,50);
            questionButton.addActionListener(this);
            add(questionButton);

		resultLabel = new JLabel("Score: XX");
			resultLabel.setBounds(100,500,500,25);
            resultLabel.setFont(new Font("Serif", Font.PLAIN, 20));
			add(resultLabel);

        ImageIcon imageIcon = new ImageIcon("earth.gif");
        JLabel gif = new JLabel(imageIcon);
            gif.setBounds(150, 500, 100, 100);
            add(gif);
            

        try
        {
            scnr = new Scanner(new FileInputStream(file));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("error! - file not found");
            // System.exit(0);
        }
        
	}


    public void actionPerformed(ActionEvent e) 
    {
		if(e.getActionCommand().equals("Check"))
		{
            
            System.out.println("_____________");
            System.out.println("Old State: " + state);
            System.out.println("Old Capital: " + capital);


            if (capitalField.getText().equalsIgnoreCase(capital))
            {
                correct++;
            }
            resultLabel.setText ("Score: " + correct + " correct");
            System.out.println("Checked Score");
                        
            state = ReadLine(file);
            capital = ReadLine(file);
            
            questionLabel.setText("What is the captital of " + state + "?");
        
            System.out.println("New State: " + state);
            System.out.println("New Wanted Capital: " + capital);
        
		}

        if(e.getActionCommand().equals("Add Question"))
		{
            PrintWriter outputStream = null;
            try
            {
                outputStream = new PrintWriter(new FileOutputStream("geography.txt", true));
            }
            catch(FileNotFoundException e2)
            {
                System.out.println("Err 404: File Not Found");
                System.exit(0);
            }
            System.out.println("Add question button");
            outputStream.println(stateField.getText());
            outputStream.println(capitalField.getText());
            outputStream.flush();
        }
    }

    public static String ReadLine(File file)
    {
       
        String line = scnr.nextLine();
        System.out.println("Read File: " + line);
        return line;
    }
    
    public static void main (String[] args)
    {
        GeographyGui gg = new GeographyGui();
        gg.setVisible(true);
    }
}

