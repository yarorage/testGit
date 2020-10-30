package ru.yaro.dao;

import ru.yaro.gwt.shared.User;

import java.util.List;

public interface UserDao {
    User getUserByLogin(String login);
    List<User> getAllUsers();
    void createUser(String login, String password, String name);
}


