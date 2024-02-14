package BabyNames;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
        setSize (600,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        sexComboBox = new JComboBox(sex);
            sexComboBox.setBounds(10,20,150,25);
            sexComboBox.addActionListener(this);
            add(sexComboBox);
        nameField= new JTextField(10);
            nameField.setBounds(200,20,100,25);
            add(nameField);
        resultLabel = new JLabel("Results");
            resultLabel.setBounds(200, 70, 300, 25);
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
        if(e.getActionCommand().equals("Search"))
		{
            if (sex.equals("female"))
            {
                file = new File ("/Users/mt25190/Desktop/CS-HL1-Projects/eclipse-workspace/TaheriMyaB3/bin/BabyNames/femaleBabyNames.txt");
                for (int i = 1; i <= 200; i++)
                {
                    
                }
            }
            else
            {
                file = new File ("/Users/mt25190/Desktop/CS-HL1-Projects/eclipse-workspace/TaheriMyaB3/bin/BabyNames/maleBabyNames.txt");
            }
        }
    }

    public static String ReadLine(File file)
    {
       
        String line = scnr.nextLine();
        System.out.println("Read File: " + line);
        return line;
    }
}
