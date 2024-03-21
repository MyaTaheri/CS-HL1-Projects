package HangmanServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import Hangman.Hangman2;

public class ServerHangman 
{
    public static void main (String[] args)
    {
        openSocket();
    }

    public static void openSocket()
    {
        final int PORT = 8080;
        try
        {   
            //creating the serve socket
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            //listen for incoming connections
            Socket clientSocket = serverSocket.accept();
            System.out.println("Clinet connceted: " + clientSocket);

            //create input and output stream
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            Hangman2 game = new Hangman2();
            boolean gameOver = false;
            out.println("Are you ready to play? " + game.getGuessArray());
            while (gameOver == false)
            {
                out.println(game.getGuessArray() + " What Letter?");
                game.checkAnswerArray(in.readLine());
            }

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch (IOException e)
        {
            
        }
    }
}
