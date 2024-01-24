import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PalindromeGui extends JFrame implements ActionListener
{
    private JTextField originalMessageField;
    private JLabel palindromeLabel;

	public PalindromeGui() {
		super("PalindromeGui");
		setSize(800,650);
        this.setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

        Color backgroundColor = new Color(237, 242, 194);
        Color fontColor = new Color (41, 77, 120);

        getContentPane().setBackground(backgroundColor);

		JLabel orignialMessageLabel = new JLabel("Enter in a phrase");
            orignialMessageLabel.setBounds(40, 40, 200, 50);
			add(orignialMessageLabel);
		originalMessageField = new JTextField("phrase", 25);
            originalMessageField.setBounds(250,40,150, 50);
			add(originalMessageField);
		palindromeLabel = new JLabel("Palindrome?");
            palindromeLabel.setBounds(40, 140, 750, 50);
            palindromeLabel.setFont(new Font("Ariel", Font.PLAIN, 16));
            palindromeLabel.setForeground(fontColor);
			add(palindromeLabel);
		JButton checkButton = new JButton("Palindrome");
            checkButton.setBounds(40,240,150,50);
            checkButton.addActionListener(this);
			add(checkButton);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Palindrome"))
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
            

            if (flippedString.equalsIgnoreCase(original))
                palindromeLabel.setText("Result: \"" + original + "\" is a palindrone.");
            else
                palindromeLabel.setText("Result: \"" + original + "\" is a NOT palindrone.");

            
		}
    }

    public static void main(String[] args) {
		PalindromeGui pg = new PalindromeGui();
		pg.setVisible(true);	
	}
}
