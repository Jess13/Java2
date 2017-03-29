package ru.geekbrains.java2.dz.dz4.Aristarkhov_Ilya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


class Window extends JFrame{
    Window(){
        setBounds(500, 200, 650, 600);
        setTitle("Chat V0.1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("messages_5122x.png"));
        setIconImage(image);

        JTextArea[] jta = new JTextArea[2];



        jta[0] = new JTextArea(2,1);
        JScrollPane jsp = new JScrollPane(jta[0]);
        add(jsp, BorderLayout.PAGE_END);

        jta[1] = new JTextArea(20,1);
        JScrollPane jsp1 = new JScrollPane(jta[1]);
        jta[1].setEditable(false);
        add(jsp1, BorderLayout.CENTER);

        for (JTextArea aJta : jta) {
            aJta.setWrapStyleWord(true);
            aJta.setLineWrap(true);
        }

        jta[0].addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    jta[1].append("Я: " + jta[0].getText());
                    writeData(jta[1].getText());
                    jta[0].setText("");
                }
            }
        });

        setVisible(true);

    }

    private void writeData(String text){
        try (PrintWriter pw = new PrintWriter(new FileWriter("1.txt"))){
            pw.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
