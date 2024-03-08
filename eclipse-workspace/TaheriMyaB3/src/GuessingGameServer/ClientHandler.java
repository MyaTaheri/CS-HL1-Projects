package GuessingGameServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

	private final Socket SOCKET;
	
	public ClientHandler(Socket s) {
		this.SOCKET = s;
	}
	public void run() {
		try (Socket SOCKET = this.SOCKET;
			BufferedReader in = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()));
            PrintWriter out = new PrintWriter(SOCKET.getOutputStream())) {
			
			guessing(out, in);
			
			in.close();
			out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			SOCKET.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void guessing(PrintWriter out, BufferedReader in) {
		int num = (int) (Math.random()*31);
		boolean check = true;
		System.out.println(num);
		while(check) {
			try {
				int guess = Integer.parseInt(in.readLine());
				System.out.println(guess);
				if(guess > num) {
					System.out.println(this.SOCKET.getInetAddress() + " Lower");
					out.println("Lower");
					out.flush();
				}
				else if(num > guess) {
					System.out.println(this.SOCKET.getInetAddress() + " Higher");
					out.println("Higher");
					out.flush();
				}
				else {
					out.println("Correct: " + num);
					out.flush();
					check = false;
				}
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	

}