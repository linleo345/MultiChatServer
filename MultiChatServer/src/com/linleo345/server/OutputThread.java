package com.linleo345.server;

import java.io.BufferedReader;
import java.io.IOException;

public class OutputThread extends Thread{
	
	private BufferedReader clientMessage;

	private boolean disconnected;
	
	public boolean badConnection;
	
	OutputThread(BufferedReader br)
	{
		clientMessage = br;

		
	}
	
	public void run()
	{
		try {
			disconnected = false;
			
			while(!disconnected)
			{
				
				String MSG = clientMessage.readLine();
				if(MSG == null)
				{
					//somehow close ...
					badConnection = true;
					break;
				}
				//System.out.println("Client: " + MSG);
				ServerMain.messages.addElement(MSG);
					
				
			}
			
			System.out.println("A client Disconnected!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void close()
	{
		
		disconnected = true;
	}
	
	
	

}
