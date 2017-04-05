package ru.geekbrains.java2.dz.dz4.esomov;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jess on 25.03.2017.
 */
public class Test extends JFrame{

    Test() {
        setTitle("TestWindow");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,400,400);
        JButton[] jb = new JButton[5];
        for (int i=0; i<5; i++) {
            jb[i] = new JButton("!"+i);
        }
        setLayout(new BorderLayout());
        add(jb[0], BorderLayout.EAST);
        add(jb[1], BorderLayout.WEST);
        add(jb[2], BorderLayout.SOUTH);
        add(jb[3], BorderLayout.NORTH);
        add(jb[4], BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Test();
    }
}
