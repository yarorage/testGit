package ru.yaro.dao;

import org.apache.ibatis.annotations.Param;
import ru.yaro.model.User;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();

    void createUser(@Param("login") String login,
                    @Param("password") String password,
                    @Param("name") String name);


    User getUserByLogin(@Param("login") String login);
}
