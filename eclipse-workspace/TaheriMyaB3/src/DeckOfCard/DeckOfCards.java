package DeckOfCard;

import java.util.Random;

public class DeckOfCards 
{

    private int currentCardNum;
    private String[] value = new String[]{"Ace","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String[] suits = new String[]{Character.toString(0x2660),Character.toString(0x2665),Character.toString(0x2663), Character.toString(0x2666)};
    private String[][] deck = new String[52][2];

    public DeckOfCards()
    {
        currentCardNum = 0;
        fillDeck();
    }

    public void fillDeck()
    {
      int index = 0;
        for (String num : value) {
            for (String suit : suits) {
                deck[index][0] = String.valueOf(num);
                deck[index][1] = String.valueOf(suit);
                index++;
            }
        }
    }


    public void shuffle()
    {

        for (int k = 52; k >= 2; k--)
        {
            int randomInt = new Random().nextInt(k);
            String tempSuit = deck[randomInt][1];
            String tempVal = deck[randomInt][0];

            deck[randomInt][0] = deck[k-1][0];
            deck[randomInt][1] = deck[k-1][1];

            deck[k-1][0] = tempVal;
            deck[k-1][1] = tempSuit;
        }
    }

    public void getCard()
    {
        System.out.println(nextCard());
    }

    public String nextCard()
    {
        String card = deck[currentCardNum][0] + " of " + deck[currentCardNum][1];
        currentCardNum++;
        return card; 
    }

    public String getCardSuit()
    {
        System.out.println(deck[currentCardNum][1]);
        return deck[currentCardNum][1];
    }

    public int cardValue(String card) {
        //finds the first number by finding the String value before the first " "
        String value = card.split(" ")[0];
        switch (value) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "Jack": return 11;
            case "Queen": return 12;
            case "King": return 13;
            case "Ace": return 1;
            default: return 0;
        }
    }

    public void printDeck()
    {
        for (int r = 0; r < 52; r++)
        {
            System.out.println(deck[r][0] + " of " + deck[r][1]);
        }
    }
}
