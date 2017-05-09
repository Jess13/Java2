package ru.geekbrains.java2.dz.dz8.esomov.server;

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
                        String log = SQLHandler.getLogin(n[1]);

                        if (log != null) {
                            if (nick != null && !owner.isNicknameUsed(nick)) {
                                owner.broadcastMsg(nick + " connected to the chatroom");
                                name = nick;
                                sendMsg("zxcvb");
                                break;
                            } else {
                                if (nick == null)
                                    sendMsg("Auth Error: Wrong Password");
                                if (owner.isNicknameUsed(nick))
                                    sendMsg("Auth Error: Account are busy");
                            }
                        } else {
                            if (log == null)
                                sendMsg("Auth Error: No such login");
                        }
                    }
                }
                Thread.sleep(100);
            }
            while (true) {
                String msg = in.readUTF();
                if (msg != null) {
                    //String[] s = msg.split("@#");
                    boolean s1 = checkMsg(msg, "@#");
                    boolean s2 = checkMsg(msg, "/changenick");
                    if (!s1 && !s2) {
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

    public boolean checkMsg (String mes, String templ) {
        String[] s = mes.split(templ);
        if (s.length == 2) {
                switch (templ) {
                    case "@#":
                        owner.broadcastMsgByUser(s[0], name + ": " + s[1]);
                        owner.broadcastMsgSelf(name, name + ": " + s[1]);
                        return true;
                        //break;
                    case "/changenick":
                        s[1] = s[1].trim();
                        if (!s[1].isEmpty()) {
                            SQLHandler.changeNick(name, s[1]);
                            owner.broadcastMsgSelf(name, name + ": changed to: " + s[1]);
                            name = s[1];
                        }
                        return true;
                        //break;
                    default:
                        return false;
                        //break;
                }
        }
        else return false;
    }
}
