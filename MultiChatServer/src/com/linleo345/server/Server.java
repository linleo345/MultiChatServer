package com.linleo345.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{
	
	
	public static ArrayList<Integer> clientIPs;
	
	private Socket client;
	private PrintWriter sendToClient;
	private BufferedReader readFromClient;
	private OutputThread output;
	private InputThread input;

	private boolean shouldDC;
	

	
	
	
	Server(Socket toAdd) throws IOException{
		client = toAdd;
		//try
		sendToClient = new PrintWriter(client.getOutputStream(), true);
		readFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
		//client.input


		
	}
	
	public void run(){
		shouldDC = false;
				
		output = new OutputThread(readFromClient);
		input = new InputThread(sendToClient);
				
		output.start(); input.start();
		
		while(!shouldDC)
		{
			if(output.badConnection)
				shouldDC = true;
			
		}
		
		this.close();

		
		
	}
	
	
	public void addMessage(String msgToAdd) {
		input.addMessage(msgToAdd);
		
	}
	
	public void close()
	{
		//call close functions
		output.close();
		input.close();
	}
	
	
	
	
	
	
}
