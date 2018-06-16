package com.lilutong.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.runner.notification.RunListener.ThreadSafe;

import jdk.internal.dynalink.beans.StaticClass;


public class Server {

	
	ServerSocket  serverSocket =null;
	InetSocketAddress  inetSocketAddress  =null;
	List<Thread> threads=null;  //未用到
	static List<Socket> sockets=null;
	
	Integer count =null;
	
	public  Server() throws IOException {
		serverSocket=new ServerSocket();
		inetSocketAddress=new InetSocketAddress("localhost", 10086);
	    serverSocket.bind(inetSocketAddress);
		
	    threads=new ArrayList<Thread>();
		sockets=new ArrayList<Socket>();
	    count=0;
		
	}
	
	
	
	
	public   static   void main(String    args[]) throws IOException{
		
		
		
		
		Server server=new Server();
		System.out.println("*********服务器即将启动,等待用户加入");
	    
			
		
			
			
		while(true) {
				
			Socket  socket=null;		
			socket=server.serverSocket.accept();
			server.sockets.add(socket);
			server.count++;
			
			InetAddress  inetAddress=socket.getInetAddress();
			System.out.println("*********第"+server.count+"位用户加入聊天室，其IP-"+inetAddress);
			
			
			SocketThread  socketThread=new SocketThread(socket);
			socketThread.setSockets(sockets);
			Thread  thread=new Thread(socketThread);
			server.threads.add(thread);
			thread.start();
			
				
				
    	}
			
			
		
		
		
		
		
	
	}

	
	
}
