package BabyNames;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableExample2 extends JFrame implements ActionListener
{
    JTable dataTable;
    JLabel dataLabel;
    JTextField nameField;
    String[] col = {"Name", "College", "GPA"};
    String[][] data = {{"Jonathan", "University of Maine", "3.14"}, 
                        {"Tate", "College of Charleston", "57"}};

    public TableExample2()
    {
        setTitle("table example 2");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        dataTable = new JTable(data, col);
            dataTable.setBounds(10,10,500,100);
            dataTable.setBackground(new Color (113, 168, 148));
            dataTable.setGridColor(Color.black);
            add(dataTable);
        JButton searchButton = new JButton("Search");
            searchButton.addActionListener(this);
            searchButton.setBounds(10,150,100,50);
            add(searchButton);
        nameField= new JTextField(10);
            nameField.setBounds(150,155,100,40);
            add(nameField);
        dataLabel = new JLabel("testing");
            dataLabel.setBounds(270,155,100,40);
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
            dataLabel.setText("searching");
        }
        
    }
    
}
