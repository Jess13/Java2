package ru.geekbrains.java2.dz.dz6.sorokinSergey.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
	private Socket s;
	private PrintWriter out;
	private Scanner in;
	private static int CLIENT_COUNT = 0;
	private String name; 
	private static Scanner scanner = new Scanner(System.in);

	public ClientHandler(Socket s) {
		try {
			this.s= s;
			out = new PrintWriter(s.getOutputStream());
			in = new Scanner(s.getInputStream());
			CLIENT_COUNT++;
			name = "Client #" + CLIENT_COUNT;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						while (true) {
							if (scanner.hasNext()) {
								String servScan = scanner.nextLine();
								out.println("server: " + servScan);
								out.flush();
							}
						}
					} catch (Exception e) {

					}
					
				}
			}).start();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			if(in.hasNext()) {
				String w = in.nextLine();
				System.out.println(name + ": " + w);
				out.println("echo: " + w);
				out.flush();
				if (w.equalsIgnoreCase("END")) break;
			}	
		}
		try {
			System.out.println("Client disconnected");
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
