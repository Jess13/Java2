package ru.geekbrains.java2.dz.dz6.esomov.client;

import ru.geekbrains.java2.dz.dz6.esomov.ConnThread;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Jess on 03.04.2017.
 */
public class CltConsole {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("127.0.0.1", 9000);
        String srv = "Server";
        System.out.println("Connected to Server");
        ConnThread ct = new ConnThread(sock, srv);
        Thread t = new Thread(ct);
        t.start();
        ct.input();
    }
}
