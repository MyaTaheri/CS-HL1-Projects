package CaeserCipher;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CaeserCipher extends JFrame implements ActionListener
{
    private JTextField phraseField;
	private JLabel resultLabel;
	private JTextField shiftNum;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

   //constructor
	public CaeserCipher() {
		super("CaeserCipher");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);


        Color backgroundColor = new Color(146, 194, 224);
        getContentPane().setBackground(backgroundColor);

		JLabel decryptedLabel = new JLabel("Enter in a phrase");
             decryptedLabel.setBounds(40, 40, 200, 50);
			add(decryptedLabel);
		phraseField = new JTextField("phrase", 25);
            phraseField.setBounds(250,40,150, 50);
			add(phraseField);
		JLabel encrypedLabel = new JLabel("Enter in Shift");
            encrypedLabel.setBounds(40, 140, 200, 50);
			add(encrypedLabel);
        shiftNum = new JTextField("Shift #", 25);
            shiftNum.setBounds(250,140,150, 50);
			add(shiftNum);
		JButton encryptButton = new JButton("Encrypt");
            encryptButton.setBounds(40,240,75,50);
            encryptButton.addActionListener(this);
			add(encryptButton);

        JButton decryptButton = new JButton("Decrypt");
            decryptButton.setBounds(300,240,75,50);
            decryptButton.addActionListener(this);
			add(decryptButton);

		resultLabel = new JLabel();
			resultLabel.setBounds(100,500,500,25);
            resultLabel.setFont(new Font("Serif", Font.PLAIN, 20));
			add(resultLabel);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Encrypt"))
		{
            int shift = Integer.parseInt(shiftNum.getText());
            String encryptedStr = "";

            for (int i = 0; i < phraseField.getText().length(); i++)
            {
                String originalString = phraseField.getText().toLowerCase();

                int orginalLetter = ALPHABET.indexOf(originalString.charAt(i));
                int newLetter = (orginalLetter + shift) % 26;
                encryptedStr = encryptedStr + ALPHABET.charAt(newLetter);
            }

            resultLabel.setText("Result: " + phraseField.getText() + " is encrypted to " + encryptedStr);
		}

        if(e.getActionCommand().equals("Decrypt"))
		{
            String originalString = phraseField.getText().toLowerCase();

            int shift = Integer.parseInt(shiftNum.getText());
            String decryptStr = "";

            for (int i = 0; i < originalString.length(); i++)
            {
                int orginalLetter = ALPHABET.indexOf(originalString.charAt(i));
                int newLetter = (orginalLetter - shift) % 26;
                if (newLetter < 0) 
                {
                    newLetter = 26 + newLetter;
                }
                decryptStr = decryptStr + ALPHABET.charAt(newLetter);
            }

            resultLabel.setText("Result: " + phraseField.getText() + " is decrypted to " + decryptStr);
		}
	}
}
