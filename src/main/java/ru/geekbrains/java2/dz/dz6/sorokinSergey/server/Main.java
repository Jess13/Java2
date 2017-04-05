package ru.geekbrains.java2.dz.dz6.sorokinSergey.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket s = null;
		
		try{
			server = new ServerSocket(8189);
			server.getInetAddress();
			System.out.println("Server created. Wating for client");
			while(true) {
				s = server.accept();
				System.out.println("Client connected");
				new Thread(new ClientHandler(s)).start();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				s.close();
				server.close();
				System.out.println("Server closed");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	

	}

}
