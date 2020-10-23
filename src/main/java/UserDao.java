import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    User getUserByLogin(String login) throws SQLException;
    List<User> getAllUsers() throws SQLException;
}

