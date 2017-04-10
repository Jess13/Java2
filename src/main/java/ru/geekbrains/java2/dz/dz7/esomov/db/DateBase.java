/*в классе DataBase реализовать два метода:
        реализовать добавление пользователей.
        реализовать измнение пароля по логину.*/

package ru.geekbrains.java2.dz.dz7.esomov.db;

import java.sql.*;


public class DateBase {
    public static final String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    public static final String user = "postgres";
    public static final String password = "postgres";
    String SQL_SELECT_ALL = "SELECT login, nickname, password  FROM main";
    String SQL_SELECT = "SELECT login, nickname, password  FROM main where login = ?";
    String SQL_UPDATE_USER = "UPDATE main SET password = ? WHERE login = ?";
    String SQL_INSERT_USER = "INSERT into main(login, nickname, password) values(?,?,?)";

    public void getConnectionToDB(String dbUrl, String user, String password, String login) {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(dbUrl, user, password)) {
            if (connection != null) {
                System.out.println("connection to db");
                System.out.println("Подключение к базе данных прошло успешно!\n");
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
                if (login != null && !login.isEmpty()) {
                    findLogin(preparedStatement, login);
//                    findLogin(statement, login);
                } else {
                    showFullTableColumnNumber(statement);
//                showFullTable(statement);
                }
                updUser(connection);
                addUser(connection);
                showFullTableColumnNumber(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updUser(Connection conn) { //Смена пароля по логину
        try {
            PreparedStatement st = conn.prepareStatement(SQL_UPDATE_USER);
            st.setString(1,"5555555555");
            st.setString(2,"log5");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(Connection conn){ //Добавление пользователя
        try {
            PreparedStatement st = conn.prepareStatement(SQL_INSERT_USER);
            st.setString(1,"log5");
            st.setString(2,"nick5");
            st.setString(3,"pass5");
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findLogin(PreparedStatement preparedStatement, String inLogin) {
        try {
            preparedStatement.setString(1, inLogin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String nickname = resultSet.getString("nickname");
                String password = resultSet.getString("password");
                System.out.println(login + "= " + nickname + "= " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findLogin(Statement statement, String inLogin) {
        try {
            String sql = "SELECT login, nickname, password  FROM main where login = '" + inLogin + "'";
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String nickname = resultSet.getString("nickname");
                String password = resultSet.getString("password");
                System.out.println(login + ", " + nickname + ", " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showFullTableColumnNumber(Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                String login = resultSet.getString(1);
                String nickname = resultSet.getString(2);
                String password = resultSet.getString(3);
                System.out.println(login + "- " + nickname + "- " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showFullTable(Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String nickname = resultSet.getString("nickname");
                String password = resultSet.getString("password");
                System.out.println(login + ", " + nickname + ", " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

