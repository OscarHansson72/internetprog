import java.io.*;
import java.net.*;

public class Client{
	
	//private static final String DEFAULT_HOST = "127.0.0.1";
	//private static final int DEFAULT_PORT = 2000;
	
	private static final String DEFAULT_HOST = "atlas.dsv.su.se";
	private static final int DEFAULT_PORT = 9494;
	
	
	public static void main(String[] args) throws IOException{
		
		String host;
		int port;
		
		if(args.length == 2){
			host = (String) args[0];
			port = Integer.parseInt(args [1]);
		}else{
			host = DEFAULT_HOST;
			port = DEFAULT_PORT;
		}
		
		
		ClientReceiver receive = new ClientReceiver(host, port);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String message = "";
		
		Socket socket = null;
		
		try{
			socket = new Socket(host, port);
			System.out.println("anslutningen till: " + socket.getRemoteSocketAddress() + " lyckades");
		}catch(IOException e){
			System.err.println("Could not connect to " + host);
			receive.setExit();
			message = "exit";
		}
		
		while(!message.equals("exit")){
			message = in.readLine();
			
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "ISO-8859-1"), true);
			out.println(message);
			out.flush();
		}
		
			
	}
}