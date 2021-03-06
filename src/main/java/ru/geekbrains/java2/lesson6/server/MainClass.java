package ru.geekbrains.java2.lesson6.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket s = null;
        try {
            server = new ServerSocket(8189);
            server.getInetAddress();
            System.out.println("Server created. Waiting for client...");
            while(true) {
                s = server.accept();
                System.out.println("Client connected");
                new Thread(new ClientHandler(s)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
                server.close();
                System.out.println("Server closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
