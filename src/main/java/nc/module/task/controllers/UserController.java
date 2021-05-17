package nc.module.task.controllers;

import nc.module.task.dao.DaoUser;
import nc.module.task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController {
    private DaoUser daoUser;

    @Autowired
    public UserController(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    @GetMapping("/api/users")
    @ResponseBody
    public List<User> showUsers() throws SQLException {
        return daoUser.getAll();
    }

    @PostMapping("/api/users")
    public void insert (@RequestBody String name) throws SQLException {
        try {
            daoUser.getByName(name);
        } catch (SQLException throwables) {
            try {
                daoUser.insert(new User(1, name, 0));
            } catch (SQLException e) {
                throw throwables;
            }
        }
    }
}
