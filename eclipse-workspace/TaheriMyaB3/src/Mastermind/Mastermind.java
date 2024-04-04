package Mastermind;

import java.util.ArrayList;
import java.util.Collections;

public class Mastermind 
{
    private int turn;
    private String[][] board = new String[8][4];
    private String [] answer = new String[4];
    private String [] rightSpots;
    private boolean won;
    private int rightSpot;
    private static final int BROWN = 0, RED = 1, BLUE = 2, ORANGE = 3, YELLOW = 4;
    private ArrayList<Integer> colors = new ArrayList<>();
    
    public Mastermind()
    {  
        colors.add(BROWN);
        colors.add(RED);
        colors.add(BLUE);
        colors.add(ORANGE);
        colors.add(YELLOW);
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
                answer[i] = "orange";
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
            screen = screen + "\n";

        }

        return screen;
       
    }

    public void setGuess(String col1, String col2, String col3, String col4)
    {
        //compare the logic here

    }

    public Boolean getWon()
    {
        return won;
    }
}
