package echoserver;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class EchoClient {
	
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {

		ClientThread client  = new ClientThread();
		client.start();
	}

class clientThread extends Thread{
	public static int myCount = 0;
	public void run(){
		while(clientThread <=10){
			try{
				System.out.println("Exp1 Thread: " +(++clientThread.myCount));
				Thread.sleep(100);
			}catch (IOException e) {
				System.out.println("Exception in thread: "+e.getMessage());
			}
		}
	}
}

class countingThread extends Thread{
	public int myCount =0;
	public int start = 0;
	public int stop = 0;

	public countingThread(int start, int stop){
		this.start=start;

	}
	
	public void run(){
		for(int i = 0;, i<20, i++) {
			
		try{ 
			OutputStream out = start.getOutputStream();
			InputStream in = start.getInputStream();

			int count;
			while((

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

			} catch (IOException e) {
				System.out.println("ERRORS!");
				System.out.println(e);
			}
		}
	}
}




//	private void start() throws IOException {
//		Socket sock = new Socket("localhost", 6013);
//		InputThread inThread = new InputThread(sock);
//		OutputThread outThread = new OutputThread(sock);
//
//		inThread.start();
//		outThread.start();
//	}
//}

