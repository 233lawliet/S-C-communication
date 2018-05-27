package com.lilutong.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.junit.experimental.theories.Theories;


public class FtpClient   extends  FTPClient {

	public FTPClient  ftpClient  =new FTPClient();
	
	public static Properties   getPorperties() throws IOException {
		
        FileInputStream  fileInputStream=new FileInputStream("resources/ftp.properties");
		Properties  properties=new Properties();
        properties.load(fileInputStream);
        return properties;
		
	}
	
	
	
	
	public   FTPClient   getClient() throws NumberFormatException, SocketException, IOException {
	    
		ftpClient.connect(FtpClient.getPorperties().getProperty("address"), Integer.parseInt(FtpClient.getPorperties().getProperty("port")));
		ftpClient.login(FtpClient.getPorperties().getProperty("user"),FtpClient.getPorperties().getProperty("password"));
	    
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
   	    ftpClient.setControlEncoding("UTF-8");
		return ftpClient;
		
	}
	
	
	
	public  boolean    upload(String filename) throws IOException {
		String  path  =this.getPorperties().getProperty("localpath")+File.separator+filename;
		File  file =new File(path);
		InputStream  inputStream=new FileInputStream(file);
		this.ftpClient.storeFile(filename, inputStream);
		

		inputStream.close();
		this.ftpClient.disconnect();
		
		return   true;
	}
	
	
	public boolean   download(String  filename) throws IOException {
		String  path  =this.getPorperties().getProperty("localpath")+File.separator+filename;
		InputStream  inputStream=this.ftpClient.retrieveFileStream(filename);
		OutputStream  outputStream  =new  FileOutputStream(path);
		int i=0;
		while(i!=-1) {
			i=inputStream.read();
			outputStream.write(i);
		}
		inputStream.close();
		outputStream.close();
		this.ftpClient.disconnect();
		return  true;
	}
	
	
	
	
	public  static void  main(String   args[]) throws IOException {
		FtpClient  ftpClientMain=new FtpClient();
		FTPClient ftpClient=ftpClientMain.getClient();
	    
	    ftpClientMain.download("test.txt");
	   
	    ftpClientMain.upload("text.txt");
	    }
		
	
	
	}

