package LocalServerSockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client 
{
    public static void main (String[] args)
    {
        final String SERVER_ADDRESS = "localhost";
        final int PORT = 8080;

        try{
            //create the client socket and connect with the server
            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            //create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String message = JOptionPane.showInputDialog("message?");
            out.println(message);
            in.close();
            out.close();
            socket.close();
        }
        catch (IOException e)
        {

        }
    }
    
}
