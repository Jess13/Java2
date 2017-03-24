package ru.geekbrains.java2.dz.dz4.esomov;

import javax.swing.*;

/**
 * Created by Jess on 25.03.2017.
 */
public class MyWindow extends JFrame{

    MyWindow(){
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,400,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
