package BabyNames;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BabyNameGui extends JFrame implements ActionListener
{
    String[] sex = {null, "female", "male"};
    JComboBox sexComboBox;
    JLabel resultLabel;

    public BabyNameGui()
    {
        setTitle("combo box example");
        setSize (800,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        sexComboBox = new JComboBox(sex);
            sexComboBox.setBounds(10,20,150,25);
            sexComboBox.addActionListener(this);
            add(sexComboBox);
        resultLabel = new JLabel("Results");
            resultLabel.setBounds(200, 20, 300, 25);
            add(resultLabel);
    }


    public static void main (String[] args)
    {
        BabyNameGui bng = new BabyNameGui(); 
        bng.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        resultLabel.setText("Sex: " + sexComboBox.getItemAt(sexComboBox.getSelectedIndex()));
    }
}
