package RemoteServerSockets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
    public static void main (String[] args)
    {
        final int PORT = 8080;
        try{
            //creating the serve socket
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);
            System.out.println(InetAddress.getLocalHost().getHostAddress());

            //listen for incoming connections
            Socket clientSocket = serverSocket.accept();
            System.out.println("Clinet connceted: " + clientSocket);

            //create input and output stream
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            JOptionPane.showMessageDialog(null, "Message from clinet is " + in.readLine());
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
