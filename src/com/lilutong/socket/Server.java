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
		
		//����ServerSocter
		ServerSocket  serverSocket  =new ServerSocket();
		InetSocketAddress  inetSocketAddress  =new InetSocketAddress("localhost", 10086);
		serverSocket.bind(inetSocketAddress);
		
		
		//����
		Socket  socket  =serverSocket.accept();
		
		//����inputStream   outputStream
		InputStream   inputStream =socket.getInputStream();
	    OutputStream  outputStream =socket.getOutputStream();
		
		//����  Scanner
		
	    Scanner  scanner  =new Scanner(System.in);
	    String   getinfo=null;
	    String   putinfo=null;
	    
	    
	    
	    //ѭ��
	    byte[] bytes=new byte[1024];
	    int count=-1;  //�������ݳ���   ���Ҷ�ȡ����
	    while(true) {
		    /**
			 * 1.���ܶԷ������� 
			 * 2.��ӡ�Է�������
			 * 3.�����Լ�������
			 * 4.��¼������ݷ��͸��Է�
			 */
		
	    	
	  
	    	Cmd  cmd =new  Cmd();
	    	//��ȡ�û�����Ϣ
	    	count=inputStream.read(bytes);
	        getinfo=new String(bytes, 0, count);
	        
		    System.out.println("�ͻ���˵�ˣ�"+getinfo);
		 		    
		    //¼������  ��Ϣ
		    //putinfo=scanner.nextLine();
		    outputStream.write(cmd.judge(getinfo).getBytes());
		    outputStream.flush();
	    
	    }
	
	}

	
	
}
