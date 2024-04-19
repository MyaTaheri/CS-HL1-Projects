package DeckOfCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighLow {
    private DeckOfCards deck;
    private String currentCard;
    private int correctGuesses;
    private int incorrectGuesses;
    private Color backgroundColor = new Color(155, 185, 232);
    private Color winColor = new Color(197, 235, 209);
    private Color loseColor = new Color(235, 200, 197);

    public HighLow() {
        deck = new DeckOfCards();
        deck.shuffle();
        currentCard = deck.nextCard();
        correctGuesses = 0;
        incorrectGuesses = 0;
    }

    // Method to show the next card and allowing the user to guess
    public void guessPage() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(375, 200);
        frame.setLayout(null);
        frame.setResizable(false);


        JLabel currentCardLabel = new JLabel("The current card is: " + currentCard);
            currentCardLabel.setBounds(10, 10, 750, 50);
        frame.add(currentCardLabel);

        JButton higherButton = new JButton("Higher");
            higherButton.setBounds(60, 75, 75, 50);
        JButton lowerButton = new JButton("Lower");
            lowerButton.setBounds(140, 75, 75, 50);
        JButton equalButton = new JButton("Equal");
            equalButton.setBounds(220, 75, 75, 50);

        frame.add(higherButton);
        frame.add(lowerButton);
        frame.add(equalButton);

        higherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess("higher", frame);
            }
        });

        lowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess("lower", frame);
            }
        });

        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess("equal", frame);
            }
        });

        frame.getContentPane().setBackground(backgroundColor);

        frame.setVisible(true);
    }

    private void handleGuess(String guess, JFrame frame) {
        String nextCard = deck.nextCard();
        int currentCardValue = deck.cardValue(currentCard);
        int nextCardValue = deck.cardValue(nextCard);

        String resultMessage = "The next card was: " + nextCard + "\n";

        if (currentCardValue == nextCardValue) {
            if (guess.equals("equal")) {
                resultMessage += "It's equal!";
                correctGuesses++;
                frame.getContentPane().setBackground(winColor);
            } else {
                resultMessage += "Sorry, you guessed incorrectly!";
                incorrectGuesses++;
                frame.getContentPane().setBackground(loseColor);
            }
        } else if ((currentCardValue < nextCardValue && guess.equals("higher")) || (currentCardValue > nextCardValue && guess.equals("lower"))) {
            resultMessage += "Congratulations, you guessed correctly!";
            correctGuesses++;
            frame.getContentPane().setBackground(winColor);
        } else {
            resultMessage += "Sorry, you guessed incorrectly!";
            incorrectGuesses++;
            frame.getContentPane().setBackground(loseColor);
        }

        int score = correctGuesses - incorrectGuesses;
        resultMessage  = resultMessage + "\nYour score is: " + score;
        JOptionPane.showMessageDialog(frame, resultMessage);

        currentCard = nextCard;

        if (correctGuesses + incorrectGuesses < 52) {
            guessPage();
        } else {
            displayFinalResult(frame);
        }
    }

    // Method to display the final result
    private void displayFinalResult(JFrame frame) {
        JOptionPane.showMessageDialog(frame, "Game Over!\nCorrect guesses: " + correctGuesses + "\nIncorrect guesses: " + incorrectGuesses);
    }

    public static void main(String[] args) {
        HighLow game = new HighLow();
        game.guessPage();
    }
}
