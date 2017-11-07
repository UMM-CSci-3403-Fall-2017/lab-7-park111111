package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {

		EchoServer server = new EchoServer();
		server.start();
	}
class EchoThread extends Thread{
	private Socket sock;
	public EchoThread(Socket socke){
		this.sock = socke;
	}
	public void run(){
		try{
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();

			int NewType;

			while((NewType = in.read()) != -1) {
				out.write(NewType);
			}
			sock.close();
			System.out.println("DISCONNECTED!!!!");
		}catch(IOException e){
		System.out.println(e);
		}
	}
}


		
