package com.lilutong.datagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP_Server {

	

	
	
	
	public static void main(String  args[]) throws IOException {
	

         byte  []   getinfo=new byte[1024];
         
         
         DatagramPacket  datagramPacket  =new  DatagramPacket(getinfo,getinfo.length);
         DatagramSocket  datagramSocket  =new  DatagramSocket(10086);
		 datagramSocket.receive(datagramPacket);
		 
		 String info=new  String(getinfo, 0, getinfo.length);
		 
	     System.out.println("服务端已经接收到到信息:"+info);
		
	     System.out.println(datagramPacket.getAddress().getHostAddress());
		
	     
	     datagramSocket.close();
	
	
	
	
	}
}
