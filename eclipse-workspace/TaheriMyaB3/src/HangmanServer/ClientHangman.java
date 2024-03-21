package HangmanServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

public class ClientHangman 
{
    public static void main (String[] args) throws UnknownHostException
    {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        String ip = InetAddress.getLocalHost().getHostAddress(); //for local computer only

        final int port = 8080;
        openSocket(ip, port);
    }

    public static void openSocket (String ip, int PORT)
    {
        try
        {
            //create the client socket and connect to the server
            Socket soc = new Socket(ip, PORT);

            //create an input stream and out stream
            BufferedReader inC = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            JOptionPane.showMessageDialog(null, inC.readLine());
            for (int k = 0; k < 7; k++)
            {
                String letterGuess = JOptionPane.showInputDialog(inC.readLine());
                out.println(letterGuess);
            }

        }
        catch (IOException e)
        {
            
        }
    }
    
}
