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
        Scanner inp = new Scanner(System.in);
        Scanner in = new Scanner(soc.getInputStream());
        PrintWriter out = new PrintWriter(soc.getOutputStream());
        System.out.println("Client connected");
        Thread cltTread = new Thread(()-> {
            while (true) {
                if (in.hasNext()) {
                    String msg = in.nextLine();
                    System.out.println("Client: " + msg);
                    if(msg.equalsIgnoreCase("END")) {
                        out.println("END");
                        out.flush();
                        break;
                    }
                }
            }
            try {
                System.out.println("Client disconnected");
                soc.close();
                in.close();
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        cltTread.start();

            while (cltTread.isAlive()) {
                if (inp.hasNext()) {
                    String msg = inp.nextLine();
                    out.println(msg);
                    out.flush();
                    if (msg.equalsIgnoreCase("END")) break;
                }
            }
            inp.close();
            System.exit(0);
    }
}
