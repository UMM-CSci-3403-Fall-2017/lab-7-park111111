package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;


public class EchoServer {
	
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {

		EchoServer server = new EchoServer();
		server.start();
	}

	class EchoThread extends Thread {
		private Socket sock;
		public EchoThread(Socket socke){
			this.sock = socke;
		}
		
		public void run() {
			try {

				OutputStream out = sock.getOutputStream();
				InputStream in = sock.getInputStream();

				int NewType;
				while((NewType = in.read()) != -1) {
					out.write(NewType);

				}
				out.flush();
				sock.close();
				System.out.println("Disconnected!");
			
			} catch (IOException e) {
				System.out.println("ERROR!");
				
				System.out.println(e);
			}
		}
	}

	void start() throws IOException, InterruptedException {
	//	@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(6013);
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("Connected!");
			EchoThread Threads = new EchoThread(socket);
			Threads.run();
		}

	}
}




