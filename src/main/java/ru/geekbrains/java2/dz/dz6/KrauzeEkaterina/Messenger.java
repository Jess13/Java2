package ru.geekbrains.java2.dz.dz6.KrauzeEkaterina;

import java.io.*;
import java.net.*;

public class Messenger {

    private static final int PORT = 6666;

    public static void main(String[] args) {
        String address = "";

        if (args.length > 0) {
            address = args[0];
        }

        boolean isServer = address.isEmpty();

        try {
            printInfo(isServer);

            Socket socket = isServer
                    ? createServerSocket(PORT)
                    : createClientSocket(address, PORT);

            serve(socket);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printInfo(boolean isServer) throws UnknownHostException {
        String message = isServer
                ? "Running as server at: " + Inet4Address.getLocalHost().getHostAddress()
                : "Running as client";

        System.out.println(message);
        System.out.println();
    }

    private static Socket createServerSocket(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        return serverSocket.accept();
    }


    private static Socket createClientSocket(String address, int port) throws IOException {
        InetAddress ipAddress = InetAddress.getByName(address);
        return new Socket(ipAddress, port);
    }

    private static void serve(Socket socket) {
        new Thread(new InputThread(socket)).start();
        new Thread(new OutputThread(socket)).start();
    }

    private static class InputThread implements Runnable {
        private Socket socket;

        InputThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream in = new DataInputStream(inputStream);

                while (true) {
                    System.out.println(in.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class OutputThread implements Runnable {
        private Socket socket;

        OutputThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream out = new DataOutputStream(outputStream);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
                    out.writeUTF(reader.readLine());
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
