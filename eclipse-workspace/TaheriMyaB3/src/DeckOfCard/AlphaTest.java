package DeckOfCard;

import javax.swing.JOptionPane;

import Mastermind.Mastermind;

public class AlphaTest 
{
    public static void main (String[] args)
    {
       DeckOfCards deck = new DeckOfCards();
       deck.printDeck();
       deck.shuffle();
       System.out.println("----------------------------");
       System.out.println("---------SHUFFLE------------");
       System.out.println("----------------------------");
       deck.printDeck();

    }
    
}
