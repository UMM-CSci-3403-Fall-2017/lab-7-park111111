package echoserver;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class EchoClient {
//	public static final int PORT_NIMBER = 6013;
//	public static InputStream sockInputStream;
//	public static OutputStream sockOutputStream;
//	public static Socket sock;

	public static void main(String[] args) throws IOException {
		try {
			Socket sock = new Socket("localhost", 6013);
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			
		//	newInputThread in = new newInputThread();
		//	newOutputThread out = new newOutputThread();

			Threads outThread = new Threads(System.in, out, sock);
			Threads inThread = new Threads(in, System.out, sock);

			outThread.start();
			inThread.start();
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
	
	
	public static class Threads extends Thread {
		InputStream input;
		OutputStream output;
		Socket sock;
		
		public Threads(InputStream input, OutputStream output, Socket sock) {
			this.input = input;
			this.output = output;
			this.sock = sock;
		}
		
		
		public void run() {
			
			try{
				int NewType;
				while((NewType = input.read()) != -1) {
					output.write(NewType);
				}
				
				output.flush();
				
				if (output.equals(System.out)){
					sock.shutdownInput();
					sock.close();
				}else {
					sock.shutdownOutput();
				}
			} catch (IOException ioe) {
				System.err.println(ioe);
			}
		}
	}
}



