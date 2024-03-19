package Hangman;

import java.util.Scanner;

//CREATE A "DRIVER" CLASS TO ALPHA TEST

public class Hangman {
    //class vairbales, instantce, globabl variables

    private static Scanner scnr = new Scanner(System.in);
    private static int guesses;
    private static WordClass wordClass;
    private static char[] answerArray;
    private static String[] latinList = {"amor", "vita", "lux", "veritas", "pax", "terra", "fides", "bellum", "fortuna", "tempus", "caelum", "mors", "ars", "natura", "aeternitas", "scientia", "libertas", "salus", "amicus", "aequitas", "sapientia", "gloria", "otium", "honos", "somnium"};

 public static void main(String[] args) {
        wordClass.setWord(latinList);
        String word = wordClass.getWord();
        int wordLength = word.length();
        //Clears screen from terminal lines in VSCode
        for (int i = 0; i < 15; i++)
        {
            System.out.println();
        }
        answerArray = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            answerArray[i] = '_';
        }
        guessing();
    }

    public static void guessing() {
        char[] wrongGuesses = new char[10]; // Assuming a maximum of 10 wrong guesses
        int wrongGuessCount = 0; // Counter to keep track of the number of wrong guesses
        while (guesses > 0) {
            System.out.println("\nGuess a lowercase letter! " + guesses + " turns left.");
            char guess = scnr.next().charAt(0);
            boolean found = false;
            for (int i = 0; i < wordClass.getWord().length(); i++) {
                if (wordClass.getWord().charAt(i) == guess) {
                    answerArray[i] = guess;
                    found = true;
                }
            }
            if (!found) {
                guesses--;
                wrongGuesses[wrongGuessCount++] = guess;
            }
            printArray();
            if (isWordGuessed()) {
                System.out.println("\nCongratulations! You've guessed the word!");
                break;
            }
            System.out.print("\nWrong guesses: ");
            for (int i = 0; i < wrongGuessCount; i++) {
                System.out.print(wrongGuesses[i] + " ");
            }
            System.out.println();
        }
        if (guesses == 0) {
            System.out.println("\nSorry, you've run out of guesses. The word was: " + wordClass.getWord());
        }
    }
    

    //https://www.programiz.com/java-programming/enhanced-for-loop
    public static void printArray() {
        for (char c : answerArray) {
            System.out.print(c + " ");
        }
    }

    public static boolean isWordGuessed() {
        for (char c : answerArray) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
