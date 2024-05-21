package DeckOfCard;

import java.util.Scanner;

public class BlackJack {
    private DeckOfCards deck;
    private int playerPoints;
    private boolean gameActive;
    private Scanner scanner;

    public BlackJack() {
        deck = new DeckOfCards();
        deck.shuffle();
        playerPoints = 0;
        gameActive = true;
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to BlackJack!");
        while (gameActive) {
            System.out.println("1. Play");
            System.out.println("2. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                play();
            } else {
                gameActive = false;
            }
        }
        System.out.println("Thank you for playing!");
    }

    private void play() {
        playerPoints = 0;
        boolean roundActive = true;

        while (roundActive) {
            System.out.println("Your points: " + playerPoints);
            System.out.println("1. Hit");
            System.out.println("2. Fold");
            int choice = scanner.nextInt();
            if (choice == 1) {
                String card = deck.nextCard();
                int cardValue = deck.cardValue(card);
                playerPoints += cardValue;
                System.out.println("You drew: " + card);
                if (playerPoints > 21) {
                    System.out.println("You busted with " + playerPoints + " points!");
                    roundActive = false;
                } else if (playerPoints >= 17 && playerPoints <= 21) {
                    System.out.println("You win with " + playerPoints + " points!");
                    roundActive = false;
                }
            } else if (choice == 2) {
                System.out.println("You folded with " + playerPoints + " points.");
                roundActive = false;
            }
        }
    }

    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.startGame();
    }
}
