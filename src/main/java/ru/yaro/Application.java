package ru.yaro;

import com.google.inject.Inject;
import ru.yaro.dao.UserDao;
import ru.yaro.gwt.shared.User;
import ru.yaro.service.Calculator;

import java.sql.SQLException;
import java.util.List;

public class Application {

    private Calculator calculator;
    private UserDao userDao;

    @Inject
    public Application(Calculator calculator, UserDao userDao) {
        this.calculator = calculator;
        this.userDao = userDao;
    }


    public void run() throws SQLException {
        System.out.println(calculator.addition(5, 6));
        List<User> allUsers = userDao.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user.getName());
        }

    }


}
