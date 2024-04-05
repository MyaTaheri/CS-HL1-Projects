package Mastermind;

import javax.swing.JOptionPane;

public class AlphaTest 
{
    public static void main (String[] args)
    {
        Mastermind g = new Mastermind();
        JOptionPane.showMessageDialog(null, g.getBoard() + "The secret code does not contains duplicates.");
        System.out.println(g.getAnswer());
        int k = 0;
        while (g.getWon() == false && k < 8)
        {
            String[] options = {"brown", "purple", "blue", "yellow", "red"};
            int a = JOptionPane.showOptionDialog(null, "Select one color for spot 1: ", "Color for spot 1", 0, 3, null, options, options);
            int b = JOptionPane.showOptionDialog(null, "Select one color for spot 2: ", "Color for spot 2", 0, 3, null, options, options);
            int c = JOptionPane.showOptionDialog(null, "Select one color for spot 3: ", "Color for spot 3", 0, 3, null, options, options);
            int d = JOptionPane.showOptionDialog(null, "Select one color for spot 4: ", "Color for spot 4", 0, 3, null, options, options);
            g.setGuess(options[a], options[b], options[c], options[d]);
            JOptionPane.showMessageDialog(null, g.getBoard());
            k++;
        }
        if (g.getWon()==true)
        {
            JOptionPane.showMessageDialog(null, "👑 you won 👑");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "you lost :( \nthe code was " + g.getAnswer());
        }
    }
    
}
