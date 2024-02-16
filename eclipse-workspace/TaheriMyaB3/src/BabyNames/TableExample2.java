package BabyNames;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TableExample2 extends JFrame implements ActionListener
{
    JTable dataTable;
    JLabel dataLabel;
    JTextField nameField;
    static Scanner scnr = null;
    File file = new File("/Users/mt25190/Desktop/CS-HL1-Projects/college.txt");

    String[] col = {"Name", "College", "GPA"};
    Object[][] data = {{"Jonathan", "University of Maine", "3.14"}, 
                        {"Tate", "College of Charleston", "57"},
                        {"Will", "College of Charleston", "56"},
                        {"Sam", "College of Hell", "55"},
                        {"Kaitlyn", "College of Charleston", "54"},
                        {"Owen", "College of Charleston", "573"},
                        {"Carlos", "College of Music", "52"}};

    public TableExample2()
    {
        setTitle("table example 2");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        dataTable = new JTable(data, col);
            JScrollPane scrollPane = new JScrollPane(dataTable);
            // dataTable.setBounds(10,10,500,100);
            dataTable.setBackground(new Color (113, 168, 148));
            dataTable.setGridColor(Color.black);
            scrollPane.setBounds(10,10,500,100);
            add (scrollPane);
            // add(dataTable);
        JButton searchButton = new JButton("Search");
            searchButton.addActionListener(this);
            searchButton.setBounds(10,150,100,50);
            add(searchButton);
        JButton saveButton = new JButton("Save");
            saveButton.addActionListener(this);
            saveButton.setBounds(10,200,100,50);
            add(saveButton);
        JButton restoreButton = new JButton("Restore");
            restoreButton.addActionListener(this);
            restoreButton.setBounds(10,250,100,50);
            add(restoreButton);
        nameField= new JTextField(10);
            nameField.setBounds(150,155,100,40);
            add(nameField);
        dataLabel = new JLabel("Press Search");
            dataLabel.setBounds(270,155,400,40);
            add(dataLabel);
    }

    public static void main (String[] args)
    {
        TableExample2 gui = new TableExample2();
        gui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Search"))
		{
            String name = nameField.getText();
            for (int c = 0; c < dataTable.getColumnCount(); c++)
            {
                for (int r = 0; r < dataTable.getRowCount(); r++)
                {
                    if (name.equalsIgnoreCase(dataTable.getValueAt(r, c).toString()))
                    {
                        dataLabel.setText(name + " is going to " + dataTable.getValueAt(r, 1).toString());
                    }
                }
            }
        }
        if(e.getActionCommand().equals("Save"))
		{
            PrintWriter outputStream = null;
            try
            {
                outputStream = new PrintWriter(new FileOutputStream("college.txt"));
            }
            catch(FileNotFoundException e2)
            {
                System.out.println("Err 404: File Not Found");
                System.exit(0);
            }
            System.out.println("Save button");
            for (int c = 0; c < dataTable.getColumnCount(); c++)
            {
                for (int r = 0; r < dataTable.getRowCount(); r++)
                {
                    outputStream.println(dataTable.getValueAt(r,c).toString());
                    outputStream.flush();
                }
            }
        }

        if(e.getActionCommand().equals("Restore"))
		{

            try
            {
                scnr = new Scanner(new FileInputStream(file));
            }
            catch(FileNotFoundException e1)
            {
                System.out.println("error! - file not found");
                // System.exit(0);
            }
            System.out.println("Restore button");

            for (int c = 0; c < dataTable.getColumnCount(); c++)
            {
                for (int r = 0; r < dataTable.getRowCount(); r++)
                {
                    String tempStr = scnr.nextLine();
                    dataTable.setValueAt(tempStr, r, c);
                }
            }
        }
        
    }
    
}
