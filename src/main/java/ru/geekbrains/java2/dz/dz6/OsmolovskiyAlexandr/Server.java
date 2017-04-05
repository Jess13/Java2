/*1. Разобраться с исходным кодом клиентской и серверной части, и для закрепления
        написать консольные эхо-сервер и клиент, без подглядывания в методичку;*/
package ru.geekbrains.java2.dz.dz6.OsmolovskiyAlexandr;
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Server side");
        BufferedReader in = null;
        PrintWriter    out= null;
        BufferedReader br=null;
        ServerSocket servers = null;
        Socket       fromclient = null;

        // create server socket
        try {
            servers = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("Couldn't listen to port 4444");
            System.exit(-1);
        }

        try {
            System.out.print("Waiting for a client...");
            fromclient= servers.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            System.out.println("Can't accept");
            System.exit(-1);
        }

        in  = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
        out = new PrintWriter(fromclient.getOutputStream(),true);
        br = new BufferedReader (new InputStreamReader (System.in));
        String         input=null,output=null;

        System.out.println("Wait for messages");
        /*while ((input = in.readLine()) != null) {
            input=in.readLine ();
           // System.out.println(input);
            if (input.equalsIgnoreCase("exit")) break;
            output=br.readLine();
            */
        while ((input = in.readLine()) != null) {
            if (input.equalsIgnoreCase("exit")) break;
            out.println("S ::: "+input);
            System.out.println(input);
            output=br.readLine();
            out.println("S ::: "+output);


        }
        out.close();
        in.close();
        fromclient.close();
        servers.close();
    }
}
