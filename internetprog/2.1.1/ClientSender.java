import java.net.*;
import java.io.*;

public class ClientSender extends Thread{
	
		
	private String message;
	private Socket socket = null;
		
	public ClientSender(String message){
		this.message = message;
		start();
	}
		
	@Override
	public void run(){
			
		try{
			socket = new Socket("atlas.dsv.su.se", 9494);
		}catch(IOException e){
			System.err.println("Could not connect to atlas.dsv.su.se");
		}
		
			
		try{
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "ISO-8859-1"), true);
			out.println(message);
			out.flush();
		}catch(IOException e){
			System.err.println("funkar ej");
		}
			
	}
}
