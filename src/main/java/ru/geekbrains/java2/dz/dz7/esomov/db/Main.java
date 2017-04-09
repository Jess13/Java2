package ru.geekbrains.java2.dz.dz7.esomov.db;


public class Main {
    public static void main(String[] args) {
        DateBase dateBase = new DateBase();
        dateBase.getConnectionToDB(DateBase.dbUrl, DateBase.user, DateBase.password, "log3");
    }
}
