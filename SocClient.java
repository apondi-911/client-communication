package com.lee;

import java.io.*;

import java.net.*;


public class SocClient
{
	//initialize socket and input output streams
	 Socket socket=null;
	 InputStreamReader inputStreamReader=null;
	 OutputStreamWriter outputStreamWriter=null;
	
	//constructor to put ip address and port
	
	@SuppressWarnings("deprecation")

	public SocClient(String ServerName,int serverport) 
	{
		//establish a connection
		try {
			//Client instantiates an object to specify server name and port number
			socket = new Socket(ServerName,serverport);
			System.out.println("Connected"); 
			
			// takes input from terminal
			input = new DataInputStream(System.in);
			
			//sends output to socket
			out= new DataOutputStream(socket.getOutputStream());
			
			
			
		} catch (IOException e) {
		
		}
		//string to read message from input lab
	
		//loop to  keep reading until Over is displayed on the screen
		while(true)
		{
			try
			{
				String line="";
				line =input.readLine();
				out.writeUTF(line);
			}
			catch (IOException e) {
				
				 System.out.println("Error");
		    }
	    }
		
    }
	public static void main(String args[])
	{
		try {
		@SuppressWarnings("unused")
		SocClient socclient= new SocClient(args[0],Integer.parseInt(args[1]));
	    }
		catch(ArrayIndexOutOfBoundsException aio){
		  
	   }
	  }
   }
	
	

	


