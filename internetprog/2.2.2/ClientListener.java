import java.net.*;
import java.io.*;

public class ClientListener extends Thread{
	
	private Server server;
	private Socket socket;
	
	public ClientListener(Server server, Socket socket){
		this.server = server;
		this.socket = socket;
		start();
	}
	
	@Override
	public void run(){
		BufferedReader in = null;
		String message = "";
		
		try{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch(IOException e){
			System.err.println(e);
		}
		
		while(true){
			try{
				message = in.readLine();
				server.distributeMessage(message);
			}catch(IOException e){
				System.err.println("Could not readLine");
			}
			System.out.println(message);
		}
	}
	
}