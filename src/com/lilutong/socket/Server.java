package com.lilutong.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class Server {

	
	
	
	
	public   static   void main(String    args[]) throws IOException {
		
		//创建ServerSocter
		ServerSocket  serverSocket  =new ServerSocket();
		InetSocketAddress  inetSocketAddress  =new InetSocketAddress("localhost", 10086);
		serverSocket.bind(inetSocketAddress);
		
		
		//监听
		Socket  socket  =serverSocket.accept();
		
		//创建inputStream   outputStream
		InputStream   inputStream =socket.getInputStream();
	    OutputStream  outputStream =socket.getOutputStream();
		
		//创建  Scanner
		
	    Scanner  scanner  =new Scanner(System.in);
	    String   getinfo=null;
	    String   putinfo=null;
	    
	    
	    
	    //循环
	    byte[] bytes=new byte[1024];
	    int count=-1;  //计算数据长度   并且读取数据
	    while(true) {
		    /**
			 * 1.接受对方的数据 
			 * 2.打印对方的数据
			 * 3.输入自己的数据
			 * 4.将录入的数据发送给对方
			 */
		
	    	
	  
	    	Cmd  cmd =new  Cmd();
	    	//获取用户的信息
	    	count=inputStream.read(bytes);
	        getinfo=new String(bytes, 0, count);
	        
		    System.out.println("客户端说了："+getinfo);
		 		    
		    //录入数据  信息
		    //putinfo=scanner.nextLine();
		    outputStream.write(cmd.judge(getinfo).getBytes());
		    outputStream.flush();
	    
	    }
	
	}

	
	
}
