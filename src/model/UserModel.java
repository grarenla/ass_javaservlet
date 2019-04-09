package model;

import entity.User;

import java.sql.*;

public class UserModel {
    Connection connection;

    public void insert(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(username, password, fullName) VALUES(?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String username, String password) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int eId = resultSet.getInt(1);
                String eUsername = resultSet.getString(2);
                String ePassword = resultSet.getString(3);
                String eFullName = resultSet.getString(4);
                String eRole = resultSet.getString(5);
                return new User(eId, eUsername, ePassword, eFullName, eRole);
            }
        } catch (InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
