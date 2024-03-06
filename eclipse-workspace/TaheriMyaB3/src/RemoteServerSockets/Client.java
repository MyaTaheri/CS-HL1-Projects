package RemoteServerSockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

public class Client 
{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private final String SERVER_ADDRESS = "10.1.8.213"; //sam
    private boolean check;
    
    public Client()
    {
        final int PORT = 8080;

        try{
            //create the client socket and connect with the server
            socket = new Socket(SERVER_ADDRESS, PORT);
            //create input and output streams
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String message = JOptionPane.showInputDialog("message?");
            out.println(message);
            guess();

            in.close();
            out.close();
            socket.close();
        }
        catch (IOException e)
        {

        }
    }

    public static void main (String[] args)
    {
        // final String SERVER_ADDRESS = "localhost";
        // final String SERVER_ADDRESS = "10.1.10.1"; //kaitlyn
        // final String SERVER_ADDRESS = "10.1.11.3"; //kyle
        Client client = new Client();

        
    }
    // private void whileChatting(String messageFromServer) {
    //     System.out.println("Message from server to client " + messageFromServer);
    // }
    
    private void guess()
    {
        try {
            String messageFromServer = in.readLine();
            System.out.println(messageFromServer);
            if (messageFromServer.equalsIgnoreCase("Lower"))
            {
                String message = JOptionPane.showInputDialog("The number is lower than previous guess. Guess again: ");
                out.println(message);
                guess();
            }
            else if (messageFromServer.equalsIgnoreCase("Higher"))
            {
                String message = JOptionPane.showInputDialog("The number is higher than previous guess. Guess again: ");
                out.println(message);
                guess();
            }
            else
            {
                System.out.println("Guessed correct!");
            }                        
        
    } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}