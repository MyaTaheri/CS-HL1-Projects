package Hangman;
import javax.swing.JOptionPane;

public class Hangman2Driver 
{
    public static void main(String [] args) 
	{
		//alpha test the game
		Hangman2 h = new Hangman2();
		System.out.println(h.getWord());
		System.out.println(h.getGuessArray());
		for(int k=0;k<7;k++) 
		{
			String letter = JOptionPane.showInputDialog("What letter?");
			h.checkAnswerArray(letter);
			JOptionPane.showMessageDialog(null,h.getGuessArray());
        }
    }
}