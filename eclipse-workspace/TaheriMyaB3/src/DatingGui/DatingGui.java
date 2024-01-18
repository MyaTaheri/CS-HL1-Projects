package DatingGui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DatingGui extends JFrame implements ActionListener
{
	private JTextField nameField;
	private JLabel resultLabel;
	private JTextField ageField;

   //constructor
	public DatingGui() {
		super("Dating Age Guesser");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JLabel nameLabel = new JLabel("Enter in your Name");
			nameLabel.setBounds(40, 40, 150, 50);
			add(nameLabel);
		nameField = new JTextField("Name Here", 25);
			nameField.setBounds(200,40,150, 50);
			add(nameField);
		JLabel ageLabel = new JLabel("Enter in your age");
			ageLabel.setBounds(40, 140, 150, 50);
			add(ageLabel);
		ageField = new JTextField("Age Here", 25);
			ageField.setBounds(200,140,150, 50);
			add(ageField);
		JButton enterButton = new JButton("Calculate");
			enterButton.setBounds(40,240,75,50);
			enterButton.addActionListener(this);
			add(enterButton);

		resultLabel = new JLabel();
			resultLabel.setBounds(100,500,500,25);
			add(resultLabel);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Calculate"))
		{
			int yourAge = Integer.parseInt(ageField.getText());
			String name = nameField.getText();
		
			if (yourAge < 0)
			{
				resultLabel.setText("Hi " + name + ", you're not a negative number");

			}
			else if (yourAge <= 14)
			{
				resultLabel.setText("Hi " + name + ", you should beocme older it. don't date idk");

			}
			else
			{
				double partnerAge = (yourAge / 2) - 7;
				double oldestAge = partnerAge + yourAge;
				double youngestAge = yourAge - partnerAge;
				resultLabel.setText("Hi " + name + ", the range of people you can date is " + oldestAge + " - " + youngestAge + ".");
			}
			
		}
	}
		
}
