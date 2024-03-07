package GuessingGameServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private boolean check = true;
	private  final int PORT;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private BufferedReader in;
	private PrintWriter out;
	
	
	public Server() {
		this.PORT = 8080;
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println(InetAddress.getLocalHost().getHostAddress());
			System.out.println("Server has started on port: "  + PORT);
			//Listen for incoming data
			clientSocket = serverSocket.accept();
			System.out.println("Client connected " + clientSocket);
			//cCReate input and output stream
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.guessing();
		
	}
	private void guessing() {
		int num = (int) (Math.random()*31);
		System.out.println(num);
		while(check) {
			try {
				int guess = Integer.parseInt(in.readLine());
				System.out.println(guess);
				if(guess > num) {
					System.out.println("Lower");
					out.println("Lower");
					out.flush();
				}
				else if(num > guess) {
					System.out.println("Higher");
					out.println("Higher");
					out.flush();
				}
				else {
					out.println("Yes: " + num);
					out.flush();
					check = false;
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
