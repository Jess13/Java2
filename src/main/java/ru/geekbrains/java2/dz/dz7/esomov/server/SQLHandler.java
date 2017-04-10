package ru.geekbrains.java2.dz.dz7.esomov.server;

import java.sql.*;

/**
 * Created by Jess on 09.04.2017.
 */
public class SQLHandler {
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "postgres"; // наверно нехорошо делать пароль публичным, но пока так
    private static final String SQL_SELECT = "SELECT Nickname FROM main WHERE Login = ? AND Password = ?;";
    private static Connection conn;
    private static PreparedStatement stmt;


    public static void connect() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            conn.close();
        } catch (Exception c) {
            System.out.println("Connection Error");
        }
    }

    public static String getNickByLoginPassword(String login, String password) {
        String w = null;
        try {
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                w = rs.getString("Nickname");
        } catch (SQLException e) {
            System.out.println("SQL Query Error");
        }
        return w;
    }

    public static int findLog(String Log) {
        int i = 0; //Кол-во найденных записей Login
        try {
            String SQL_FIND_LOGIN = "SELECT login FROM main where login = '" + Log + "'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_LOGIN);
            while (resultSet.next()) {
                String login = resultSet.getString("login");
                if (!login.equals("")) i++;
            }
        } catch (SQLException e) {
                System.out.println("SQL Query Error");
            }
        return i;
    }

    public static void updPassword(String chgPass) {
        connect();
        String[] u =  chgPass.split("\t");
        if (!u[0].equals("") && !u[1].equals("")) {
            int flag = findLog(u[0]); //Если flag=0 то не обновлять базу
            if (flag != 0) {
                String SQL_UPDATE_PASS = "UPDATE main SET password = ? WHERE login = ?";

                try {
                    stmt = conn.prepareStatement(SQL_UPDATE_PASS);
                    stmt.setString(1, u[1]);
                    stmt.setString(2, u[0]);
                    stmt.executeUpdate();

                } catch (SQLException e) {
                    System.out.println("SQL Query Error");
                }
            }
            else System.out.println("Login is not found!");
        }
        disconnect();
    }

    public static void addNewUser(String regUser) {
        connect();
        String[] u = regUser.split("\t");
        if (!u[0].equals("Login") && !u[1].equals("Password") && !u[2].equals("NickName")
        && !u[0].equals("") && !u[1].equals("") && !u[2].equals("")) {
            String SQL_INSERT_USER = "INSERT into main(login, password, nickname) values(?,?,?)";

            try {
                stmt = conn.prepareStatement(SQL_INSERT_USER);
                stmt.setString(1, u[0]);
                stmt.setString(2, u[1]);
                stmt.setString(3, u[2]);
                stmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println("SQL Query Error");
            }
        }
        disconnect();
    }
}
