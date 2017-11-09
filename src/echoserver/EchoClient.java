package echoserver;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class EchoClient extends Thread {
	
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {

		EchoClient client  = new EchoClient();
		client.start();
	}	

	class ClientThread extends Thread {
		private Socket sock;
		public ClientThread(Socket socke) {
			this.sock = socke;
		}
		public void run(){
			try{
				OutputStream out = sock.getOutputStream();
				InputStream in = sock.getInputStream();

				int NewType;
				while((NewType = in.read()) != -1) {
					out.write(NewType);
				}

				out.flush();
				sock.close();
				System.out.println("Disconnected!");

			} catch (IOException ioe) {
				System.out.println("ERRORS!");
				System.out.println(ioe);
			}
		}
	}
}
