package com.linleo345.server;

public class MessageHandler extends Thread {
	
	MessageHandler(){
		
		
	}
	
	public void run()
	{
		
		while(true) {
			
			if(!ServerMain.messages.isEmpty())
			{
				if(!ServerMain.messages.lastElement().equals(null))
				{
					
					String msg = ServerMain.messages.lastElement();
					ServerMain.messages.remove(ServerMain.messages.size() - 1);
					//loop through all clients and send the message
					for(int i = 0; i < ServerMain.clients.size(); i++)
					{
						
						ServerMain.clients.get(i).addMessage(msg);
						
						
					}
					
					
				}
			}
			
		}
		
	}
	


}





