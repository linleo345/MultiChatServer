package com.linleo345.server;

import java.io.PrintWriter;
import java.util.Vector;



public class InputThread extends Thread	{
	
	private PrintWriter msgToSend;

	private boolean disconnected;

	public Vector<String> messageList;
	
	InputThread(PrintWriter pw)
	{
		msgToSend = pw;


		
	}
	
	
	public void run()
	{
		disconnected = false;
		messageList = new Vector<String>(0);

			
			
			while(!disconnected)
			{
				if(!messageList.isEmpty())
				{
					String msg = messageList.lastElement();
					msgToSend.println(msg);
				}
		
			}
			//System.out.println("-----Client Disconnected------");
			

		
		
		
	}
	
	public void close()
	{
		disconnected = true;
		
	}
	
	public void addMessage(String msg)
	{
		messageList.add(msg);
		
	}

}
