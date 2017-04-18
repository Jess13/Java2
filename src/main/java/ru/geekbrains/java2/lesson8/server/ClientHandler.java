package ru.geekbrains.java2.lesson8.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler implements Runnable {
    private MyServer owner;
    private Socket s;
    private DataOutputStream out;
    private DataInputStream in;
    private String name;
    private int authTimer;

    public int getAuthTimer() {
        return authTimer;
    }

    public void setAuthTimer(int authTimer) {
        this.authTimer = authTimer;
    }

    public String getName() {
        return name;
    }

    public ClientHandler(Socket s, MyServer owner) {
        try {
            this.s = s;
            this.owner = owner;
            out = new DataOutputStream(s.getOutputStream());
            in = new DataInputStream(s.getInputStream());
            name = "";
            authTimer = 0;
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String w = in.readUTF();
                if (w != null) {
                    System.out.println(w);
                    String[] n = w.split("\t");
                    System.out.println(Arrays.toString(n));
                    if (n[0].equals("addNewUser")) {
                        SQLHandler.addNewUser(n[1], n[2], n[3]);
                        continue;
                    }
                    if (n[0].equals("changePassword")) {
                        SQLHandler.changePassword(n[1], n[2]);
                        continue;
                    }
                    if (n[0].equals("auth")) {
                        String nick = SQLHandler.getNickByLoginPassword(n[1], n[2]);
                        if (nick != null && !owner.isNicknameUsed(nick)) {
                            owner.broadcastMsg(nick + " connected to the chatroom");
                            name = nick;
                            sendMsg("zxcvb");
                            break;
                        } else {
                            if (nick == null)
                                sendMsg("Auth Error: No such account");
                            if (owner.isNicknameUsed(nick))
                                sendMsg("Auth Error: Account are busy");
                        }
                    }
                }
                Thread.sleep(100);
            }
            while (true) {
                String msg = in.readUTF();
                if (msg != null) {
                    String[] s = msg.split("@#");
                    if (s.length == 2) {
                        owner.broadcastMsgByUser(s[0], name + ": " + s[1]);
                    } else {
                        owner.broadcastMsg(name + ": " + msg);
                        System.out.println(name + ": " + msg);
                        if (msg.equalsIgnoreCase("END")) break;
                    }
                }
                Thread.sleep(100);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (InterruptedException e) {
            System.out.println("Thread sleep error");
        } finally {
            close();
        }
    }

    public void close() {
        try {
            System.out.println("Client disconnected");
            owner.remove(this);
            s.close();
            if (!name.isEmpty())
                owner.broadcastMsg(name + " disconnected from the chatroom");
        } catch (IOException e) {
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
        }
    }
}
