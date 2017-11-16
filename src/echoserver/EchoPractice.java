package echoserver;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.*

public class EchoClient extends Thread {
	
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {

		EchoClient client  = new EchoClient();
		client.start();
	}
	public ClientThread extends Thread {
		try{
			server = new ServerSocket(6013);
		}catch(IOException e){
			e.printStackTracE();
			System.exit(0);
		}
		
		while(true):
