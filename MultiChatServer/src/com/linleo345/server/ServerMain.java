package com.linleo345.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;


//todo: reprogram input output threads to not be 1 to 1 
//keep vector of clients(sockets) and 

public class ServerMain {
	
	public static Vector<Server> clients = new Vector<Server>(1);
	public static Vector<String> messages = new Vector<String>(0);
	
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		
		
		messages.add("Hey there!");
		
		System.out.println("Your port m8?: ");
		Scanner s = new Scanner(System.in);
		int portName= s.nextInt();
		
		
		
		try {
			
			ServerSocket server = new ServerSocket(portName);
			//add multi sending messages thread here :(
			
			Socket sa = server.accept();
			
			clients.add(new Server(sa));
			//Server working = new Server(sa);
			clients.lastElement().start();
			
			MessageHandler msgHandler = new MessageHandler();
			msgHandler.start();
			
			
			while(true)
			{
				sa = server.accept();
				
				clients.add(new Server(sa));
				//Server working = new Server(sa);
				clients.lastElement().start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Binding failed.. :( \n Try a gooder number?");
		}
		
		
//		
//		try (
//	            ServerSocket serverSocket =
//	                new ServerSocket(portName);
//	            Socket clientSocket = serverSocket.accept();     
//	            PrintWriter out =
//	                new PrintWriter(clientSocket.getOutputStream(), true);                   
//	            BufferedReader in = new BufferedReader(
//	                new InputStreamReader(clientSocket.getInputStream()));
//	        ) 
//			{
//	            String inputLine;
//	            while ((inputLine = in.readLine()) != null) { 
//	                out.println(inputLine);
//	            }
//	        } catch (IOException e) 
//			{
//	            System.out.println("Exception caught when trying to listen on port "
//	                + portName + " or listening for a connection");
//	            System.out.println(e.getMessage());
//	        }
//		
//		s.close();
	}

}
