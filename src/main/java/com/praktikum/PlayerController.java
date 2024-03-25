package com.praktikum;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    private Connection connection;

    public PlayerController(Connection connection) {
        this.connection = connection;
    }

    public void createPlayer(Player player) throws SQLException {
        String query = "INSERT INTO players (name, age, position) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, player.getName());
            preparedStatement.setInt(2, player.getAge());
            preparedStatement.setString(3, player.getPosition());
            preparedStatement.executeUpdate();
        }
    }

    public Player getPlayerById(int id) throws SQLException {
        String query = "SELECT * FROM players WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Player(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getInt("age"), resultSet.getString("position"));
                }
            }
        }
        return null;
    }

    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM players";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                players.add(new Player(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getInt("age"), resultSet.getString("position")));
            }
        }
        return players;
    }

    public void updatePlayer(Player player) throws SQLException {
        String query = "UPDATE players SET name = ?, age = ?, position = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, player.getName());
            preparedStatement.setInt(2, player.getAge());
            preparedStatement.setString(3, player.getPosition());
            preparedStatement.setInt(4, player.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deletePlayer(int id) throws SQLException {
        String query = "DELETE FROM players WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}

