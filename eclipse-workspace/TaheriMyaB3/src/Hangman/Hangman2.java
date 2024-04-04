package Hangman;
public class Hangman2 

{
	//class variable, instance variables, global variables
	private String [] words = {"hola","adios","tampoco"};
	private String word;
	private int len;
	private char [] answerArray,guessArray;

	//constructor
	public Hangman2() 
	{
		word = words[(int)(Math.random()*words.length)];
		len = word.length();
		guessArray = new char[len];
		answerArray = new char[len];
		setArrays();
	}

	public int getLen() 
	{
		return len;
	}

	public String getWord() 
	{
		return word;
	}

	private void setArrays() 
	{
		for(int k=0; k<len; k++) 
		{
			guessArray[k]= '▢' ;
			answerArray[k]=word.charAt(k);
		}
	}

	public String getGuessArray() 
	{

		String temp = "";
		for(char x:guessArray) 
		{
            temp += x;
		}
		return temp;
	}

	public String getanswerArray() 
	{

		String temp = "";
		for(char x:answerArray) 
		{
			temp += x;
		}
		return temp;
	}

	public void checkAnswerArray(String g) 
	{

		char letter = g.charAt(0);
		for(int k=0; k<answerArray.length; k++) 
		{
			if(answerArray[k] == letter) 
			{
			    guessArray[k]=letter;
			}
		}
	}

	public boolean endGame()
	{
		for (int i = 0; i < guessArray.length; i++)
		{
			if (guessArray[i] == '▢')
			{
				return false;
			}
		}
		return true;
	}
}