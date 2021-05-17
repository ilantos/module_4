package nc.module.task.dao;

import nc.module.task.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DaoQuestion {
    private Connection connection;

    @Autowired
    public DaoQuestion(Connection connection) {
        this.connection = connection;
    }

    public Question getQuestionById(int id) throws SQLException {
        String query = "SELECT * FROM questions WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Question question = new Question(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4)
        );
        return question;
    }
}
