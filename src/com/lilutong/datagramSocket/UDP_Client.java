package com.lilutong.datagramSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class UDP_Client {

	
	
	
	
	
	public static  void  main(String   args[]) throws UnknownHostException, IOException {
	
		
		 
		 byte[] info ="UDP客户端的测试信息".getBytes();
		 InetSocketAddress  inetAddress   =new  InetSocketAddress("localhost", 10086);
		 
		 DatagramPacket  datagramPacket=new DatagramPacket(info, info.length, inetAddress);
		 DatagramSocket  datagramSocket=new  DatagramSocket();
		 datagramSocket.send(datagramPacket);
		
		 System.out.println("客户端信息已经发出!");
		 
	
		 datagramSocket.close();
		 
		
	
	}
}
