package ru.geekbrains.java2.dz.dz7.esomov.client;

import ru.geekbrains.java2.dz.dz7.esomov.server.SQLHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Jess on 09.04.2017.
 */
public class MyWindow extends JFrame{

    JTextField jtf;
    JTextArea jta;

    final String SERVER_ADDR = "localhost";
    final int SERVER_PORT = 8189;
    Socket sock;
    DataInputStream in;
    DataOutputStream out;

    public MyWindow() {
        setBounds(600, 300, 500, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel authPanel = new JPanel(new GridLayout());
        JPanel regPanel = new JPanel(new GridLayout());
        JPanel chgPassPanel = new JPanel(new GridLayout());
        //Форма авторизации
        JTextField jtfLogin = new JTextField("Login");
        JTextField jtfPass = new JTextField("Password");
        JButton jbAuth = new JButton("Auth");
        authPanel.add(jtfLogin);
        authPanel.add(jtfPass);
        authPanel.add(jbAuth);
        jtfLogin.setToolTipText("Login");
        //Форма регистрации
        JTextField tfRegLogin = new JTextField("Login");
        JTextField tfRegPass = new JTextField("Password");
        JTextField tfRegNick = new JTextField("NickName");
        JButton buttonReg = new JButton("Sing Up");
        regPanel.add(tfRegLogin);
        regPanel.add(tfRegPass);
        regPanel.add(tfRegNick);
        regPanel.add(buttonReg);
        //Форма смены пароля
        JTextField tfChgLogin = new JTextField("Login");
        JTextField tfChgPass = new JTextField("Change Password");
        JButton buttonChgPass = new JButton("ChangePass");
        chgPassPanel.add(tfChgLogin);
        chgPassPanel.add(tfChgPass);
        chgPassPanel.add(buttonChgPass);

        add(topPanel, BorderLayout.NORTH);
        topPanel.add(regPanel, BorderLayout.NORTH);
        topPanel.add(chgPassPanel, BorderLayout.CENTER);
        topPanel.add(authPanel, BorderLayout.SOUTH);

        buttonChgPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String updReq = tfChgLogin.getText() + "\t" + tfChgPass.getText();
                SQLHandler.updPassword(updReq);
            }
        });

        buttonReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String regRequest = tfRegLogin.getText() + "\t" + tfRegPass.getText() + "\t" + tfRegNick.getText();
                SQLHandler.addNewUser(regRequest);
            }
        });

        jbAuth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect("auth\t" + jtfLogin.getText() + "\t" + jtfPass.getText());
            }
        });

        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSend = new JButton("SEND");
        bottomPanel.add(jbSend, BorderLayout.EAST);
        jtf = new JTextField();
        bottomPanel.add(jtf, BorderLayout.CENTER);

        jbSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtf.getText().trim().isEmpty()) {
                    sendMsg();
                    jtf.grabFocus();
                }
            }
        });

        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                try {
                    out.writeUTF("end");
                    out.flush();
                    out.close();
                    in.close();
                } catch (IOException exc) {
                } finally {
                    try {
                        sock.close();
                    } catch (IOException ex) {
                    }
                }
            }
        });

        setVisible(true);
    }

    public void connect(String cmd) {
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
            out.writeUTF(cmd);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String w = in.readUTF();
                        if (w != null) {
                            if (w.equalsIgnoreCase("end session")) break;
                            jta.append(w);
                            jta.append("\n");
                            jta.setCaretPosition(jta.getDocument().getLength());
                        }
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }

    public void sendMsg() {
        try {
            String a = jtf.getText();
            out.writeUTF(a);
            out.flush();
            jtf.setText("");
        } catch (IOException e) {
            System.out.println("Send msg error");
        }
    }
}
