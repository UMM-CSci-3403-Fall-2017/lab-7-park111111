package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class EchoServers {
	
	public static final int PORT_NUMBER = 6013;
	public static ExecutorService pool;

	public static void main(String[] args) throws IOException, InterruptedException {

		ServerSocket socket = new ServerSocket(6013);
		fixedThreadPool = Executors.newFixedThreadPool(2);

		while(true){
			Socket sock = socket.accept();
			EchoThread ThreadServer = new EchoThread(sock);
			pool.execute(ThreadServer);
		}
	}

	public static class EchoThread implements Runnable {
		Socket sock;
		public EchoThread(Socket sock) {
			this.sock = sock;
		}

		public void run() {
			try{
				OutputStream out = sock.getOutputStream();
				InputStream in = sock.getInputStream();
				
				int NewType;
				while((NewType = in.read()) != -1) {
					out.write(NewType);
					System.out.println(NewType);
				}
				System.out.flush();
				out.flush();
				sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

