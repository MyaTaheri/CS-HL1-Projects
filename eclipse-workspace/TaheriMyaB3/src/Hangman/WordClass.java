package Hangman;

import java.util.Random;

public class WordClass 
{
    String[] latinList = {"amor", "vita", "lux", "veritas", "pax", "terra", "fides", "bellum", "fortuna", "tempus", "caelum", "mors", "ars", "natura", "aeternitas", "scientia", "libertas", "salus", "amicus", "aequitas", "sapientia", "gloria", "otium", "honos", "somnium"};
    String word;

    public void setWord() {
        int randomInt = (int)Math.floor(Math.random() * (latinList.length));
        this.word = latinList[randomInt];
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
