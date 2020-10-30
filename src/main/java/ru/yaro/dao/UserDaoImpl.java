package ru.yaro.dao;

import com.google.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ru.yaro.gwt.shared.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Inject
    private SqlSessionFactory factory;

    @Override
    public User getUserByLogin(String login) {
        try (SqlSession sqlSession = factory.openSession()) {
            return sqlSession.getMapper(UserMapper.class).getUserByLogin(login);
        }

    }

    @Override
    public List<User> getAllUsers() {

        try (SqlSession session = factory.openSession()) {
            return session.getMapper(UserMapper.class).getUsers();
        }
    }

    @Override
    public void createUser(String login, String password, String name) {
        try (SqlSession sqlSession = factory.openSession(true)) {
            sqlSession.getMapper(UserMapper.class).createUser(login, password, name);
        }
    }

}








