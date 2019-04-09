package model;

import entity.Feedback;

import java.sql.*;
import java.util.ArrayList;

public class FeedbackModel {
    Connection connection;

    public void insert(Feedback feedback) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO feedbacks(title, description, userId) VALUES(?, ?, ?)");
            preparedStatement.setString(1, feedback.getTitle());
            preparedStatement.setString(2, feedback.getDescription());
            preparedStatement.setInt(3, feedback.getUserId());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Feedback> getList(String sql) {
        ArrayList<Feedback> feedbackArrayList = new ArrayList<>();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int eId = resultSet.getInt(1);
                String eTitle = resultSet.getString(2);
                String eDescription = resultSet.getString(3);
                int eUserId = resultSet.getInt(4);
                int eStatus = resultSet.getInt(5);
                Feedback feedback = new Feedback(eId, eTitle, eDescription, eUserId, eStatus);
                feedbackArrayList.add(feedback);
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return feedbackArrayList;
    }

    public void delete(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM feedbacks WHERE id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void update(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE feedbacks SET status = 1 WHERE id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
