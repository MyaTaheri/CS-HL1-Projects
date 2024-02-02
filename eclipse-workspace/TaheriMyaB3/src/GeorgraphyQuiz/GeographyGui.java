package GeorgraphyQuiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;

public class GeographyGui extends JFrame implements ActionListener
{
    private File file = new File ("/Users/mt25190/Desktop/CS-HL1-Projects/eclipse-workspace/TaheriMyaB3/src/GeorgraphyQuiz/geography.txt");
    private JTextField phraseField;
	private JLabel resultLabel;
	private JTextField shiftNum;
    static Scanner scnr = null;
    
    public GeographyGui()
    {
        super("GeographyGui");		
        setSize(450,650);
        this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);


        Color backgroundColor = new Color(215, 210, 250);
        getContentPane().setBackground(backgroundColor);

		JLabel decryptedLabel = new JLabel("State:");
             decryptedLabel.setBounds(40, 40, 200, 50);
			add(decryptedLabel);
		phraseField = new JTextField("state", 25);
            phraseField.setBounds(250,40,150, 50);
			add(phraseField);
		JLabel encrypedLabel = new JLabel("Enter Capital:");
            encrypedLabel.setBounds(40, 140, 200, 50);
			add(encrypedLabel);
        shiftNum = new JTextField("capital", 25);
            shiftNum.setBounds(250,140,150, 50);
			add(shiftNum);
		JButton encryptButton = new JButton("Check");
            encryptButton.setBounds(40,240,75,50);
            encryptButton.addActionListener(this);
			add(encryptButton);
        JButton decryptButton = new JButton("Add Question");
            decryptButton.setBounds(250,240,150,50);
            decryptButton.addActionListener(this);
            add(decryptButton);

		resultLabel = new JLabel("Score: X out of 50 Correct");
			resultLabel.setBounds(100,500,500,25);
            resultLabel.setFont(new Font("Serif", Font.PLAIN, 20));
			add(resultLabel);
	}


    public void actionPerformed(ActionEvent e) 
    {
		if(e.getActionCommand().equals("Check"))
		{
            ReadLine(file);
		}

        if(e.getActionCommand().equals("Add Question"))
		{
            
        }
    }

    public static String ReadLine(File file)
    {
        // Scanner scnr = null;

        try
        {
            scnr = new Scanner(new FileInputStream(file));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("error! - file not found");
            // System.exit(0);
        }
       
        String line = scnr.nextLine();
        String line2 = scnr.nextLine();

        System.out.println("State: " + line);
        System.out.println("State: " + line2);
        scnr.close();
        return line;
    }
    
    public static void main (String[] args)
    {
        GeographyGui gg = new GeographyGui();
        gg.setVisible(true);
    }
}

