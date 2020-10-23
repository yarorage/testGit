import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    URL resource = this.getClass().getResource("mydatabase.db");
    String path;

    {
        try {
            path = resource.toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private final String JDBCurl = ("jdbc:sqlite:" + path);

    public UserDaoImpl() {
    }


    @Override
    public User getUserByLogin(String login) throws SQLException {
        User user = new User();
        try (Connection connection = DriverManager.getConnection(JDBCurl)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("select * from USERS WHERE login =?")) {
                preparedStatement.setString(1, login);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        user.setLogin(resultSet.getString("login"));
                        user.setPassword(resultSet.getString("password"));
                        user.setName(resultSet.getString("name"));
                        return user;
                    } else {
                        return null;
                    }
                }
            }

        }

    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        ArrayList<User> arrayList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBCurl)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("Select * From USERS")) {
                    while (resultSet.next()) {
                        User user = new User();
                        user.setLogin(resultSet.getString("login"));
                        user.setPassword(resultSet.getString("password"));
                        user.setName(resultSet.getString("name"));
                        arrayList.add(user);

                    }
                }
            }
            return arrayList;
        }
    }
}








