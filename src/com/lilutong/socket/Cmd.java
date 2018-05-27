package com.lilutong.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.lilutong.ftp.FtpClient;


public class Cmd {

	
	
	
	public String   getDir(String cmd) throws IOException {
		
		Process process =Runtime.getRuntime().exec("cmd /c ls");
		InputStream  inputStream=process.getInputStream();
		
		byte  []bytes=new byte[1024];
		int  count =-1;
		count=inputStream.read(bytes);
		
		
		String result=new String(bytes, 0, count);
	
		return  result;
	}
	
	
	
   public String   getPath(String cmd) throws IOException {
		//windows
		Process process =Runtime.getRuntime().exec("cmd /c pwd");
        //liniux
		//Process process =Runtime.getRuntime().exec("/bin/sh -c pwd");
		InputStream  inputStream=process.getInputStream();
		
		byte  []bytes=new byte[1024];
		int  count =-1;
		count=inputStream.read(bytes);
		
		
		String result=new String(bytes, 0, count);
	
		return  result;
	}
	
   
   
   public  String  upload(String   filename) throws NumberFormatException, SocketException, IOException {
	   FtpClient  ftpClientMain=new FtpClient();
	   FTPClient ftpClient=ftpClientMain.getClient();
	   ftpClientMain.upload(filename);
	   return  "上传成功了";
   }
   public  String  download(String   filename) throws NumberFormatException, SocketException, IOException {
	   FtpClient  ftpClientMain=new FtpClient();
	   FTPClient ftpClient=ftpClientMain.getClient();
	   ftpClientMain.download(filename);
	   return  "下载成功了";
   
   }
   
   
   

	
	public   String  judge(String cmd) throws IOException {
	    
		if(cmd.substring(0, 2).equals("ls")) {
			return  this.getDir(cmd);
		}else if(cmd.substring(0,3).equals("pwd")) {
			return  this.getPath(cmd);	
		}
		
		else if(cmd.substring(0, 6).equals("upload")) {
			return this.upload(cmd.substring(6).trim());
		}else if(cmd.substring(0, 8).equals("download")) {
			return this.download(cmd.substring(8).trim());
		}else {
			return  "请重新输入!";
		}
		
		
				
	}

}
