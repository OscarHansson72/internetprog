import java.net.*;
import java.io.*;

public class ClientReceiver extends Thread{
	
	private Socket socket = null;
	private String message = "";
	private String host;
	private int port;
	private boolean exit = false;
		
	public ClientReceiver(String host, int port){
		this.host = host;
		this.port = port;
		start();
	}
		
	@Override
	public void run(){
		BufferedReader in = null;
		
		try{
			socket = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch(IOException e){
			System.err.println("Could not connect to " + host);
			exit = true;
		}
		
		
		while(!message.equals("exit") && !exit){
			try{
				message = in.readLine();
			}catch(IOException e){
				System.err.println("Could not readLine");
			}
			System.out.println(message);
		}			
	}
	
	public void setExit(){
		exit = true;
	}
	
}