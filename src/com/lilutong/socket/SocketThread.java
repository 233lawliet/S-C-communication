package com.lilutong.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.RadioButton;

public class SocketThread  implements  Runnable{

	
	Socket  socket=null;
	List<Socket>  sockets =new ArrayList<Socket>();   //目前所有的通信socket
	InputStream    inputStream  =null;
	OutputStream   outputStream =null;
	
	
	public SocketThread(Socket socket) {
	    this.socket=socket;
	}
	
	public void setSockets(List<Socket> sockets) {
		this.sockets=sockets;
	}
	
	
	
    //信息接受
    public String  receive() throws IOException {
    	int count=-1;
		byte[] data=new byte[1024];
    	String  dataToString=null;


    	inputStream=socket.getInputStream();
		count=inputStream.read(data);   //将数据读进data   并且计数
		dataToString=new String( data, 0, count);    //格式转换
		
		System.out.println("IP-"+socket.getInetAddress()+"说:"+dataToString);	
    	return dataToString;
		
    }
	
	//信息发送
    public void  send(String  info,Socket socket) {
    	try {
	    	outputStream=socket.getOutputStream();
	    	outputStream.write(info.getBytes());
	        outputStream.flush();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
    /*****信息广播 *****/
    
    public  void radio(String info) throws IOException {
    

    	for(Socket socket:sockets) {
    	
    		if(socket.equals(this.socket)) {
    			
    		}else {
    			this.receive();
        		this.send(info,socket);    			
    		}

    	}		
    }
    
    

	@Override
	public void run(){
			
			while(true) {
			    try {
		
		    	    String  info="IP-"+socket.getInetAddress()+":"+this.receive();   //接受信息
			        //this.send(info, socket);       //发送信息
			    	this.radio(info);
			    	
			    } catch (IOException e) {
					e.printStackTrace();
				}    
			}
					
	}
	

}
