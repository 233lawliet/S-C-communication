package com.lilutong.ftp;

import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTPClient;


public class FtpCmd {

	FtpClient  ftpClientMain=null;
	FTPClient ftpClient=null;

	public FtpCmd() throws NumberFormatException, SocketException, IOException {
		ftpClientMain=new FtpClient();
		ftpClient=ftpClientMain.getClient();
		
	}
	
	
	public   String    judge(String   cmd) throws IOException {
		if(cmd.equals("ls")) {
			return ftpClientMain.getListFile();
		}else if(cmd.equals("pwd")){
			return  ftpClientMain.getPath();
		}else if(cmd.substring(0,2).equals("cd")) {
			return ftpClientMain.changePath(cmd.substring(2).trim());
		}else if(cmd.substring(0, 6).equals("upload")) {
			if(ftpClientMain.upload(cmd.substring(6).trim())) {
				return  "�ļ��ϴ��ɹ�";
			}else {
				return  "�ļ��ϴ�ʧ��";
			}
		}else if(cmd.substring(0, 8).equals("download")) {
			if(ftpClientMain.upload(cmd.substring(8).trim())) {
				return  "�ļ����سɹ�";
			}else {
				return  "�ļ�����ʧ��";
			}
		}else {
			return  null;
		}
		
		
		
		
	}
	
	public   static  void  main(String  args[]) throws NumberFormatException, SocketException, IOException {
		FtpCmd  ftpCmd =new FtpCmd();


		Scanner  scanner  =new Scanner(System.in);
		String  cmd =null;   
		
		while(true) {

			cmd=scanner.nextLine();
			
			System.out.println(ftpCmd.judge(cmd));
			
		}
	}
}
