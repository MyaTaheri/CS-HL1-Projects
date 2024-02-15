package BabyNames;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNameGui extends JFrame implements ActionListener
{
    String[] sex = {null, "female", "male"};
    JComboBox sexComboBox;
    private File file;
    JLabel resultLabel;
    static Scanner scnr = null;
    JTextField nameField;

    public BabyNameGui()
    {
        setTitle("baby name gui");
        setSize (750,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        Color backgroundColor = new Color(151, 204, 188);
        getContentPane().setBackground(backgroundColor);
       
        sexComboBox = new JComboBox(sex);
            sexComboBox.setBounds(10,20,150,25);
            sexComboBox.addActionListener(this);
            add(sexComboBox);
        nameField= new JTextField(10);
            nameField.setBounds(200,20,100,25);
            add(nameField);
        resultLabel = new JLabel("Results");
            resultLabel.setBounds(200, 70, 500, 25);
            add(resultLabel);
        JButton searchButton = new JButton("Search");
            searchButton.addActionListener(this);
            searchButton.setBounds(10,70,150,25);
            add(searchButton);
    }


    public static void main (String[] args)
    {
        BabyNameGui bng = new BabyNameGui(); 
        bng.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String sex = (String) sexComboBox.getItemAt(sexComboBox.getSelectedIndex());
        String givenName = nameField.getText();
        String numOfNames = "";
        int rank = 0;
        String result = "";
        if(e.getActionCommand().equals("Search"))
		{
            if (sex.equals("female"))
            {
                file = new File ("/Users/mt25190/Desktop/CS-HL1-Projects/eclipse-workspace/TaheriMyaB3/bin/BabyNames/femaleBabyNames.txt");
                
                try
                {
                    scnr = new Scanner(new FileInputStream(file));
                }
                catch(FileNotFoundException e1)
                {
                    System.out.println("error! - file not found");
                    // System.exit(0);
                }

                System.out.println("Find: " + givenName);
                while (scnr.hasNextLine())
                {
                    rank++;
                    if (scnr.nextLine().equalsIgnoreCase(givenName))
                    {
                        numOfNames = scnr.nextLine();
                        result = "The name, " + givenName + ", is ranked #" + ((rank/2)+1) + " and has " + numOfNames + " births.";
                    }
                    System.out.println(rank);
                }
                resultLabel.setText(result);
                if (rank == 200)
                {
                    result = "The name, " + givenName + ", is not ranked in the top 100 babies name on the " + sex + " list";
                    resultLabel.setText(result);
                }

            }
            else if (sex.equals("male"))
            {
                file = new File ("/Users/mt25190/Desktop/CS-HL1-Projects/eclipse-workspace/TaheriMyaB3/bin/BabyNames/maleBabyNames.txt");
                try
                {
                    scnr = new Scanner(new FileInputStream(file));
                }
                catch(FileNotFoundException e1)
                {
                    System.out.println("error! - file not found");
                    // System.exit(0);
                }

                System.out.println("Find: " + givenName);
                while (scnr.hasNextLine())
                {
                    rank++;
                    if (scnr.nextLine().equalsIgnoreCase(givenName))
                    {
                        numOfNames = scnr.nextLine();
                        result = "The name, " + givenName + ", is ranked #" + ((rank/2)+1) + " and has " + numOfNames + " births.";
                    }
                    System.out.println(rank);
                }
                resultLabel.setText(result);
                if (rank == 200)
                {
                    result = "The name, " + givenName + ", is not ranked in the top 100 babies name on the " + sex + " list";
                    resultLabel.setText(result);
                }
            }
            else if (sex.equals(null))
            {
                resultLabel.setText("select gender");
            }
        }
    }
}
