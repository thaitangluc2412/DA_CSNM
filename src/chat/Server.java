package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static int count = 1;
	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(1819);
		while(true) {
			Socket socket=server.accept(); 
			ChatServerThread thread = new ChatServerThread(socket, count++);
			thread.start();
		}
		
	}
}
