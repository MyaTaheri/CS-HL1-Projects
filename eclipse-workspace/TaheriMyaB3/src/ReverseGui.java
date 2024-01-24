import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ReverseGui extends JFrame implements ActionListener
{
    private JTextField originalMessageField;
    private JLabel flippedMessageLabel;

	public ReverseGui() {
		super("ReverseGui");
		setSize(800,650);
        this.setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);



        Color backgroundColor = new Color(191, 245, 205);
        Color fontColor = new Color (41, 77, 120);

        getContentPane().setBackground(backgroundColor);

		JLabel orignialMessageLabel = new JLabel("Enter in a phrase");
            orignialMessageLabel.setBounds(40, 40, 200, 50);
			add(orignialMessageLabel);
		originalMessageField = new JTextField("phrase", 25);
            originalMessageField.setBounds(250,40,150, 50);
			add(originalMessageField);
		flippedMessageLabel = new JLabel("Flipped Message");
            flippedMessageLabel.setBounds(40, 140, 750, 50);
            flippedMessageLabel.setFont(new Font("Ariel", Font.PLAIN, 16));
            flippedMessageLabel.setForeground(fontColor);
			add(flippedMessageLabel);
		JButton flipButton = new JButton("Flip");
            flipButton.setBounds(40,240,75,50);
            flipButton.addActionListener(this);
			add(flipButton);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Flip"))
		{
            String original = originalMessageField.getText();
            String flippedString = "";

            for (int i = 0; i < original.length(); i++)
            {
                flippedString = original.charAt(i) + flippedString;
            }
            
            /* Alternate Method:
             StringBuffer b = new StringBuffer(original);
            flippedString = b.reverse().toString();
             */
            
            flippedMessageLabel.setText("Result: \"" + originalMessageField.getText() + "\" is flipped to \"" + flippedString + "\"");

            
            
		}
    }

    public static void main(String[] args) {
		ReverseGui rg = new ReverseGui();
		rg.setVisible(true);	
	}
}
