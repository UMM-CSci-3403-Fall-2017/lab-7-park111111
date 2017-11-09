package echoserver;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class EchoClient {
	public static void main(String [] args) {
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader reader = null;
		PrintWriter writer = null;
		BufferedReader stdin = null;
		try{
			//connect to server
			socket = new Socket("!27.0.0.1" , 6013);
			System.out.println("Success to connect!");
			
			//stream for server communication
			in = socket.getInputStream();
			out = socket.getOutputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(new OutputStreamWriter(out));
			stdin = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			String echo = null;

			// communicate with server
			while((msg = stdin.readLine()) !=null) {
				writer.println(msg);
				writer.flush();
				echo = reader.readLine();
				System.out.println("$tSERVER>"+echo);
			}
		} catch(IOException e) {
			System.out.println(e);
		}finally {
			try{
				stdin.close();
				reader.close();
				writer.close();
				in.close();
				out.close();
				socket.close();
				System.out.println("Disconnected!");
			} catch(IOException e) {
				System.out.println(e);
			}
		}
	}
}


