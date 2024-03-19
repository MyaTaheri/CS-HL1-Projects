package Hangman;

import java.util.Random;

public class WordClass 
{
    String word;

    public void setWord(String[] list) {
        int randomInt = (int)Math.floor(Math.random() * (list.length));
        this.word = list[randomInt];
    }

    public String getWord()
    {
        return this.word;
    }

    public char[] getArray()
    {
        int wordLength = word.length();
        char[] wordArray = new char[wordLength];
        for (int i = 0; i < wordLength; i++)
        {
            wordArray[i] = word.charAt(i);
        }
        return wordArray;
    }

}
