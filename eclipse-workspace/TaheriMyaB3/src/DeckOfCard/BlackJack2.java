package DeckOfCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJack2 extends JFrame implements ActionListener {
    private DeckOfCards deck;
    private JButton playButton;
    private JButton hitButton;
    private JButton foldButton;
    private JLabel playerPointsLabel;
    private JLabel cardLabel;
    private int playerPoints;

    public BlackJack2() {
        deck = new DeckOfCards();
        deck.shuffle();

        // GUI setup
        setTitle("Blackjack");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        playButton = new JButton("Play");
        playButton.addActionListener(this);
        add(playButton);

        hitButton = new JButton("Hit");
        hitButton.addActionListener(this);
        hitButton.setEnabled(false);
        add(hitButton);

        foldButton = new JButton("Fold");
        foldButton.addActionListener(this);
        foldButton.setEnabled(false);
        add(foldButton);

        playerPointsLabel = new JLabel("Player Points: 0");
        add(playerPointsLabel);

        cardLabel = new JLabel("Card Drawn: n/a");
        add( cardLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            playGame();
        } else if (e.getSource() == hitButton) {
            hit();
        } else if (e.getSource() == foldButton) {
            fold();
        }
    }

    private void playGame() {
        playerPoints = 0;

        String playerCard1 = deck.nextCard();
        String playerCard2 = deck.nextCard();
        playerPoints += deck.cardValue(playerCard1) + deck.cardValue(playerCard2);
        playerPointsLabel.setText("Player Points: " + playerPoints);

       

        hitButton.setEnabled(true);
        foldButton.setEnabled(true);
    }

    private void hit() {
        String newCard = deck.nextCard();
        playerPoints += deck.cardValue(newCard);

        cardLabel.setText("Card Drawn: " + newCard);

        playerPointsLabel.setText("Player Points: " + playerPoints);

        if (playerPoints > 21) {
            JOptionPane.showMessageDialog(this, "Player busts! Dealer wins!");
            endGame();
        }
        

    }

    private void fold() {
        if (playerPoints <= 21 && playerPoints >= 18) {
            JOptionPane.showMessageDialog(this, "Player win!");
            endGame();
        }
        else
            JOptionPane.showMessageDialog(this, "Player folds! Dealer wins!");
        endGame();
    }

    private void endGame() {
        // Disable hit and fold buttons
        hitButton.setEnabled(false);
        foldButton.setEnabled(false);

        // Reset the deck
        deck.shuffle();
    }

    public static void main(String[] args) {
        BlackJack2 blackjack = new BlackJack2();
        blackjack.setVisible(true);
    }
}
