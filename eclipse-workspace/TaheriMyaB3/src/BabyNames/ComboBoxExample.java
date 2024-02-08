package BabyNames;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxExample extends JFrame implements ActionListener{

    String[] instruments = {null, "drums", "keyboard", "guitar", "trumpet"};
    JComboBox instrumentCombo;
    JLabel resultLabel;

    public ComboBoxExample()
    {
        setTitle("combo box example");
        setSize (800,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        instrumentCombo = new JComboBox(instruments);
            instrumentCombo.setBounds(10,20,150,25);
            instrumentCombo.addActionListener(this);
            add (instrumentCombo);
        resultLabel = new JLabel("Instrument Company");
            resultLabel.setBounds(200, 20, 300, 25);
            add(resultLabel);
    }


    public static void main (String[] args)
    {
        ComboBoxExample gui = new ComboBoxExample(); 
        gui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        resultLabel.setText("Please play: " + instrumentCombo.getItemAt(instrumentCombo.getSelectedIndex()));
    }
    
}
