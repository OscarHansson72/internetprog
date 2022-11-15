import java.net.*;
import java.io.*;
import java.util.*;

public class Server{
	
	private static final int DEFAULT_PORT = 2000;
	private List<Socket> clientList = new ArrayList<Socket>();
	private int port;
	private ServerSocket serverSocket = null;
	
	public static void main(String[] args){
		Server server = new Server();
		
		
		if(args.length > 0){
			server.port = Integer.parseInt(args[0]);
		}else{
			server.port = DEFAULT_PORT;
		}
		
		
		try{
			server.serverSocket = new ServerSocket(server.port);
		}catch(IOException e){
			System.err.println("the client could not connect");
		}
		
		
		
		while(true){
			try{
				Socket connection = server.serverSocket.accept();
				server.clientList.add(connection);
				ClientListener clientListener = new ClientListener(server, connection);
			}catch(IOException e){
				System.err.println("the client could not connect");
			}
		}
		
		
		
	}
	
	public void distributeMessage(String message){
		
		for(Socket client: clientList){
			try{
				PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), "ISO-8859-1"), true);
				out.println(message);
				out.flush();
			}catch(IOException e){
				System.err.println(e);
			}
		}
	}
	
	
}