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

    // public void shuffle()
    // {
    //     for (int i = 0; i < 100; i++)
    //     {
    //         int randNum1 = new Random().nextInt(52);
    //         int randNum2 = new Random().nextInt(52);
    //         String randCardSuit1 = deck[randNum1][1];
    //         String randCardVal1 = deck[randNum1][0];
    //         String randCardSuit2 = deck[randNum2][1];
    //         String randCardVal2 = deck[randNum2][0];

    //         deck[randNum2][1] = randCardSuit1;
    //         deck[randNum2][0] = randCardVal1;

    //         deck[randNum1][1] = randCardSuit2;
    //         deck[randNum1][0] = randCardVal2;
    //     }
    // }

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
        currentCardNum++;
    }

    public String nextCard()
    {
        String card = deck[currentCardNum][0] + " of " + deck[currentCardNum][1];
        return card; 
    }

    public void printDeck()
    {
        for (int r = 0; r < 52; r++)
        {
            System.out.println(deck[r][0] + " of " + deck[r][1]);
        }
    }
}
