package echoserver;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class EchoClient {
	public static void main(String [] args) {
		try{
			//connect to server
			socket = new Socket("!27.0.0.1" , 6013);
			System.out.println("Success to connect!");
			
