package echoserver;

import java.io.*;
import java.net.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public lass EchoThreadServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(6013);
			System.out.println("waiting for connet");

			while(true){
				Socket socket = server.accept();
				EchoThread ethr = new EchoThread(socket);
				ehtr.start();

			}
		}catch (Exception e) {
			System.out.prinln(e);
		}
	}
}

class EchoThread extends Thread{
	private Socket sock;
	public EchoThread(Socket socke){
	       this.sock = socke;
	}

public void run	



//strat write from here





/**public class EchoServer {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {
		EchoServer server = new EchoServer();
		server.start();
	} 
	*/


public class MultiEchoServer {
	ServerSocket server;
	static final int port = 6013;
	Socket child;
	
	public MultiEchoServer(){
		try{
			server = new ServerSocket(port);
		}catch(Exception e);
		e.printStackTrace();
		System.exit(0);
	}
	System.out.println(********Chat Server********);
	System.out.println("Server waiting for Client Socket access request");
	
	while(true){
		try{
			child = server.accept();
			EchoServerThread childThread  = new EchoServerThread(child);
			Thread t = new Thread(childThread);
			t.start();
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
	}
}

public static void main(String[] args) {
	new MultiEchoServer();
	
	class EchoServerThread Implement Runnable {
		Socket child;
		InputStream is;
		ObjectInputStream ois;
		OutputStream os;
		ObjectOutputStram oos;
		String receiveData;
		
		
		public EchoServerThread(Socket s) {
			child = s;
			try {
				
				System.out.println(child.getlentAddress() + "access from");
				
				is = child.getInputStream();
				ois = new ObjectInputStream(is);

				os = child.getOutputStream();
				oos = new ObjectOutputStream(os);
			
			}catch(Exception e){
				e.printSTackTRace();
			
			}
		}
		
		public void run() {
			
			try{
				while(true){
					receiveData = (String)ois.readObject();
					oos.wrieObject(receiveData);
					oos.flush();
				}
			}catch(Exception e){
				
				System.out.prinln("Client forced turn off");
			}
			finally {
				try {
					is.closse();
					os.close();
					ois.close();
					oos.close();
					child.close();
				}catch(Exception e) {
					e.printStackTRace();
				}
			}
		}
	}


/*	private void start() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		while (true) {
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			int b;
			while ((b = inputStream.read()) != -1) {
				outputStream.write(b);
			}
		}
	}
}
*/ 



