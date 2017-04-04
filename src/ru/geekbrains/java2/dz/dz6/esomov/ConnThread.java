package ru.geekbrains.java2.dz.dz6.esomov;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Jess on 03.04.2017.
 */
public class ConnThread extends Thread {
    private String msg, msg2;
    private Socket sock;
    private String s;
    private Scanner in, inp;
    private PrintWriter out;

    public ConnThread(Socket sock, String s) throws IOException {
        this.sock = sock;
        this.s = s;
        inp = new Scanner(System.in);
        in = new Scanner(sock.getInputStream());
        out = new PrintWriter(sock.getOutputStream());
    }

    public void run () {
        while (true) {
            if (in.hasNext()) {
                msg = in.nextLine();
                System.out.println(s+": " + msg);
                if(msg.equalsIgnoreCase("END")) {
                    out.println("END");
                    out.flush();
                    break;
                }
            }
        }
        out.close();
        in.close();
        inp.close();
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void input () {
        while (true) {
            if (inp.hasNext()) {
                msg2 = inp.nextLine();
                out.println(msg2);
                out.flush();
            }
        }
    }
}
