package ru.yaro.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.apache.ibatis.session.SqlSession;
import ru.yaro.dao.UserDao;
import ru.yaro.dao.UserDaoImpl;
import ru.yaro.dao.UserMapper;
import ru.yaro.gwt.client.GwtAppService;
import ru.yaro.gwt.shared.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.List;

public class GwtAppServiceImpl extends RemoteServiceServlet implements GwtAppService {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        final Injector injector = (Injector) config.getServletContext().getAttribute(Injector.class.getName());
        injector.injectMembers(this);
    }

    @Inject
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
       return userDao.getAllUsers();
    }
}
