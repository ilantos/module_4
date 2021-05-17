package nc.module.task.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DaoTemplate {
    private Connection connection;

    @Autowired
    public DaoTemplate(Connection connection) {
        this.connection = connection;
    }

    public void getAll() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

        }

    }

    public void getById() throws SQLException {
        String query = "";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "?");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

        }
    }

    public void insertUpdateDelete(int id) throws SQLException {
        String query = "";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "?");
        statement.executeUpdate();
    }
}
