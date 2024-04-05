package Mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Mastermind 
{
    private int turn = 0;
    private String[][] board = new String[8][4];
    private String [] answer = new String[4];
    private int rightSpotRightColor = 0;
    private boolean won;
    private static final int BROWN = 0, RED = 1, BLUE = 2, PURPLE = 3, YELLOW = 4;
    private ArrayList<Integer> colors = new ArrayList<>();
    private String[] guessResults = {"", "", "", "", "", "", "", ""};
    HashMap<String, String> colorsMap = new HashMap<String, String>();


    public Mastermind()
    {  
        //for random colors
        colors.add(BROWN);
        colors.add(RED);
        colors.add(BLUE);
        colors.add(PURPLE);
        colors.add(YELLOW);

        //emoji moment
        colorsMap.put("brown", "🤎");
        colorsMap.put("red", "💔");
        colorsMap.put("blue", "💙");
        colorsMap.put("purple", "💜");
        colorsMap.put("yellow", "💛");

        setAnswer();
        fillBoard();
    }

    private void setAnswer()
    {

        Collections.shuffle(colors);
        int currentColor;

        for (int i = 0; i < 4; i++) {
            currentColor = colors.get(i);
            if (currentColor == 0)
            {
                answer[i] = "brown";
            }
            else if (currentColor == 1)
            {
                answer[i] = "red";
            }
            else if (currentColor == 2)
            {
                answer[i] = "blue";
            }
            else if (currentColor == 3)
            {
                answer[i] = "purple";
            }
            else if (currentColor == 4)
            {
                answer[i] = "yellow";
            }
        }
    }

    private void fillBoard()
    {
        for (int r = 0; r < 8; r++)
        {
            for (int c = 0; c < 4; c++)
            {
                this.board[r][c] = "-";
            }
        }
    }

    public String getAnswer()
    {
        String answer = "";
        for (int i = 0; i < 3; i++)
        {
            answer = answer + this.answer[i] + ", ";
        }
        answer = answer + this.answer[3];
        return answer;
    }

    public String getBoard()
    {        
       String screen = "";
       
       for (int r = 0; r < 8; r++)
        {
            screen = screen + (r+1) + ":";
            for (int c = 0; c < 4; c++)
            {
                screen = screen + " " + this.board[r][c];
            }
            screen = screen + " " + guessResults[r];
            screen = screen + "\n";
        }
        return screen;
    }

    public void setGuess(String col1, String col2, String col3, String col4)
    {
        this.rightSpotRightColor = 0;
        int wrongSpotRightColor = 0;

        for (int i = 0; i < 4; i++)
        {
            if (col1 == answer[i] || col2 == answer[i] || col3 == answer[i] || col4 == answer[i])
            {
                wrongSpotRightColor++;
            }
        }

        if (col1 == answer[0])
        {
            rightSpotRightColor++;
        }
        if (col2 == answer[1])
        {
            rightSpotRightColor++;
        }
        if (col3 == answer[2])
        {
            rightSpotRightColor++;
        }
        if (col4 == answer[3])
        {
            rightSpotRightColor++;
        }

        wrongSpotRightColor -= rightSpotRightColor;

        board[turn][0] = colorsMap.get(col1);
        board[turn][1] = colorsMap.get(col2);
        board[turn][2] = colorsMap.get(col3);
        board[turn][3] = colorsMap.get(col4);
        guessResults[this.turn] = "   " + rightSpotRightColor + " are in the right spot. " + wrongSpotRightColor + " are in the wrong spot, but right color. ";

        turn++;
        
    }
    
    public Boolean getWon()
    {
        if (this.rightSpotRightColor == 4)
            won = true;
        return won;
    }
}
