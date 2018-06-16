package com.lilutong.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class Client {

	
	
	public  static void  main(String  args[]) throws IOException {
		
		//创建 Socket
		Socket  socket  =new  Socket();
		InetSocketAddress  inetSocketAddress  =new InetSocketAddress("localhost", 10086);
		socket.connect(inetSocketAddress, 1000);
				
		//获取输入输出流
		InputStream  inputStream  =socket.getInputStream();
		OutputStream  outputStream  =socket.getOutputStream();
		//创建Scanner
		Scanner  scanner=new  Scanner(System.in);
		String  getinfo=null;
		String  putinfo=null;
		byte  []bytes=new byte[1024];
		int  count=-1;
		//循环 
		while(true) {
			//发送信息
			putinfo=scanner.nextLine();
			outputStream.write(putinfo.getBytes());
			outputStream.flush();
		
			//获取信息
			count =inputStream.read(bytes);
			getinfo=new  String(bytes,0, count);
			System.out.println(getinfo);
			
			
			
		}
		
		
		
	}
}
