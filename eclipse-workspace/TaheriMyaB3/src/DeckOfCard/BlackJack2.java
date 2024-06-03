package DeckOfCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJack2 extends JFrame implements ActionListener {
    private DeckOfCards deck;
    private JButton playButton;
    private JButton hitButton;
    private JButton standButton;
    private JLabel playerPointsLabel;
    private JLabel cardLabel;
    private int playerPoints;
    private Color backgroundColor = new Color(209, 182, 185);

    public BlackJack2() {
        deck = new DeckOfCards();
        deck.shuffle();

        this.getContentPane().setBackground(backgroundColor);

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

        standButton = new JButton("Stand");
        standButton.addActionListener(this);
        standButton.setEnabled(false);
        add(standButton);

        playerPointsLabel = new JLabel("Player Points: 0");
        add(playerPointsLabel);

        cardLabel = new JLabel("Card Drawn: n/a");
        add(cardLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            playGame();
        } else if (e.getSource() == hitButton) {
            hit();
        } else if (e.getSource() == standButton) {
            stand();
        }
    }

    private void playGame() {
        playerPoints = 0;

        String playerCard1 = deck.nextCard();
        String playerCard2 = deck.nextCard();
        if (deck.cardValue(playerCard1) > 10)
            playerPoints += 10;
        else
            playerPoints += deck.cardValue(playerCard1);   
        if (deck.cardValue(playerCard2) > 10)
            playerPoints += 10;
        else
            playerPoints += deck.cardValue(playerCard2);
            
        playerPointsLabel.setText("Player Points: " + playerPoints);

       

        hitButton.setEnabled(true);
        standButton.setEnabled(true);
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

    private void stand() {
        if (playerPoints <= 21 && playerPoints >= 18) {
            JOptionPane.showMessageDialog(this, "Player win!");
            endGame();
        }
        else
            JOptionPane.showMessageDialog(this, "Player folds! Dealer wins!");
        endGame();
    }

    private void endGame() {
        hitButton.setEnabled(false);
        standButton.setEnabled(false);

        deck.shuffle();
    }

    public static void main(String[] args) {
        BlackJack2 blackjack = new BlackJack2();
        blackjack.setVisible(true);
    }
}
