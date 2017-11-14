package echoserver;

import java.net.*;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EchoServerThread {
	public static void main(String[] args){
		try{
			ServerSocket socke = new ServerSocket(6013);

				ExecutiveService polls = Executors.newFixedThreadpool(64);

				while(true){
					System.out.println("READY!");
					Socket sock = socke.accept();

					EchoThread serverThread = new EchoThread(sock);
					pool.execute(serverThread);
				}
		}catch (IOException ioe) {
			System.oout.println(ioe);
		}
	}

	public static class EchoThread extends Thread {
		Socket sock;
		public EchoThread(Socket sock){
			this.sock = socke;
		}
		public void run(){
			try{
				OutputStream out = sock.getOutputStream();
				InputStream in = sock.getInputStream();

				int NewType;
				while((NewType = in.read()) != -1)
					out.write(NewType);
		
			out.flush();
			sock.shutdownOutput();
			sock.close();
		}catch (IOException e){
			System.out.println(e);
		}
	}
}
}
