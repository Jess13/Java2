package ru.geekbrains.java2.dz.dz7.esomov.server;

/**
 * Created by Jess on 09.04.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        SQLHandler.connect();
        MyServer w = new MyServer();
    }
}
