package BabyNames;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableExample extends JFrame implements ActionListener
{
    String[] columns = {"Name", "Birth Gender", "Amount of Babies"};
    String[][] data = {{"Tate", "Male", "400"}, 
                        {"Owen", "Male", "666"}, 
                        {"Delany", "Female", "17"}};

    public TableExample()
    {
        setTitle("table example");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JTable table1 = new JTable(3,4);
            table1.setBounds(10,10,150,150);
            table1.setBackground(new Color (25, 64, 125));
            add(table1);

        JTable table2 = new JTable(data, columns);
            table2.setBounds(10,500,400,60);
            table2.setBackground(new Color(134, 166, 217));
            add(table2);

    }

    public static void main (String[] args)
    {
        TableExample gui = new TableExample();
        gui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) 
    {
       
        
    }
    
}
