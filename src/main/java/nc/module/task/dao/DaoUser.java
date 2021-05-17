package nc.module.task.dao;

import nc.module.task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DaoUser {
    private Connection connection;

    @Autowired
    public DaoUser(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            users.add(new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3)
            ));
        }
        return users;
    }

    public void insert(User user) throws SQLException {
        String query = "INSERT INTO users (name, max_total_points) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setInt(2, user.getId());
        statement.executeUpdate();
    }

    public User getByName(String name) throws SQLException {
        String query = "SELECT * FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        User user = new User(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getInt(3)
        );

        return user;
    }
}
