package ru.geekbrains.java2.dz.dz6.esomov.server;
import ru.geekbrains.java2.dz.dz6.esomov.ConnThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by Jess on 03.04.2017.
 */
public class SrvConsole {
    public static void main(String[] args) throws IOException {
        ServerSocket srvSoc = new ServerSocket(9000);
        Socket sock = srvSoc.accept();
        String clt = "Client";
        System.out.println("Client connected");
        ConnThread ct = new ConnThread(sock, clt);
        Thread t = new Thread(ct);
        t.start();
        ct.input();
    }
}
