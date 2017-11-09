package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class EchoServer {
	public static void main(String [] args) {
		ServerSocket server = null;
		Socket socket = null;
		InetAddress inetAddr = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			//create server socket
			server = new ServerSocket(6013);

			//waiting for client connection
			System.out.println("====Waiting for client connection(port:"+server.getLocalPort()+")++++");
			socket = server.accept();

			//request client connection
			inetAddr = server.getInetAddress();
			System.out.println("client("+inetAddr.getHostAddress()+")connection");

			//create stream for clinet communication
			in = socket.getInputStream();
			out = socket.getOutputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(new OutputStreamWriter(out));
			String msg = null;

			//communicate with client
			while((msg = reader.readLine()) !=null) {
				System.out.println("$tCLIENT>" +msg);
				writer.println(msg);
				writer.flush();
			}
		} catch(IOException e) {
			System.out.println(e);
		}finally {
			try {
				reader.close();
				writer.close();
				in.close();
				out.close();
				socket.close();
				server.close();
				System.out.println("Disconnect!");
			} catch(IOException e) {
				System.out.println(e);
			}
		}
	}
}



