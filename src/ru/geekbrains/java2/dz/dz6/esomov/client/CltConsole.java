package ru.geekbrains.java2.dz.dz6.esomov.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Jess on 03.04.2017.
 */
public class CltConsole {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("127.0.0.1", 9000);
        Scanner in = new Scanner(sock.getInputStream()), inp;
        PrintWriter out = new PrintWriter(sock.getOutputStream());
        System.out.println("Connected to Server");
        Thread srvThread = new Thread(()-> {
            while (true) {
                if (in.hasNext()) {
                    String msg = in.nextLine();
                    System.out.println("Server: " + msg);
                    if (msg.equalsIgnoreCase("END")) break;
                }
            }
            try {
                System.out.println("Client disconnected");
                sock.close();
                in.close();
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        srvThread.start();

        inp = new Scanner(System.in);
        while (true) {
            if (inp.hasNext()) {
                String msg = inp.nextLine();
                out.println(msg);
                out.flush();
                if (msg.equalsIgnoreCase("END")) break;
            }
        }
//        out.flush();
//        out.close();
//        in.close();
//        inp.close();
//        sock.close();
    }
}
