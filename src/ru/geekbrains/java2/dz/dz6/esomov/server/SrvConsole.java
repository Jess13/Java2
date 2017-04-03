package ru.geekbrains.java2.dz.dz6.esomov.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Jess on 03.04.2017.
 */
public class SrvConsole {
    public static void main(String[] args) throws IOException {
        ServerSocket srvSoc = new ServerSocket(9000);
        Socket soc = srvSoc.accept();
        Scanner in = new Scanner(soc.getInputStream());
        PrintWriter out = new PrintWriter(soc.getOutputStream());
        System.out.println("Client connected");
        Thread cltTread = new Thread(()-> {
                if (in.hasNext()) {
                    String msg = in.nextLine();
                    System.out.println("Server: " + msg);
                    out.println("Server: " + msg);
                    out.flush();
                }

            try {
                System.out.println("Client disconnected");
                soc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        cltTread.start();
    }
}
