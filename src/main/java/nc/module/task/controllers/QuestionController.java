package nc.module.task.controllers;

import nc.module.task.dao.DaoQuestion;
import nc.module.task.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.Random;

@Controller
public class QuestionController {
    private DaoQuestion daoQuestion;

    @Autowired
    public QuestionController(DaoQuestion daoQuestion) {
        this.daoQuestion = daoQuestion;
    }

    @GetMapping("/api/question")
    @ResponseBody
    public Question getRandomQuestion() throws SQLException {
        Random rn = new Random();
        int random = rn.nextInt(10) + 1;
        return daoQuestion.getQuestionById(random);
    }
}
