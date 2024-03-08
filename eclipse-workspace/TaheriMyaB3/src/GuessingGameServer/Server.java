package GuessingGameServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private  final int PORT;
	private static ServerSocket serverSocket;
	
	
	public Server() {
		this.PORT = 8080;
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server has started on port: "  + PORT);						
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		while(true){
			try {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client connected " + clientSocket);
				new Thread(new ClientHandler(clientSocket)).start();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}