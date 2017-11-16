package echoserver;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class EchoClients {
	public static final int PORT_NIMBER = 6013;
	public static InputStream sockInputStream;
	public static OutputStream sockOutputStream;
	public static Socket sock;

	public static void main(String[] args) throws IOException {
		sock = new Socket("localhost", 6013);
		sockInputStream = sock.getInputStream();
		sockOutputStream = sock.getOutputStream();


		newInputThread in = new newInputThread();
		newOutputThread out = new newOutputThread();

		Thread outThread = new Thread(out, "outThread");
		Thread inThread = new Thread(in, "inThread");

		outThread.start();
		inThread.start();
	}
	
	public static class newInputThread implements Runnable {
		
		public void run() {
			try{
				int NewType;
				while((NewType = System.in.read()) != -1) {
					sockOutputStream.write(NewType);
				}
				sockOutputStream.flush();
				sock.shutdownOutput();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static class newOutputThread implements Runnable {
		public void run() {
			try{
				int NewType;
				while((NewType = sockInputStream.read()) != -1) {
						System.out.write(NewType);
				}
				System.out.flush();
				sock.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

