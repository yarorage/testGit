package ru.yaro;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.sqlite.SQLiteDataSource;
import ru.yaro.Main;
import ru.yaro.dao.UserDao;
import ru.yaro.dao.UserDaoImpl;
import ru.yaro.dao.UserMapper;
import ru.yaro.service.Calculator;
import ru.yaro.service.CalculatorImpl;

import javax.inject.Singleton;
import java.net.URISyntaxException;
import java.net.URL;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Calculator.class).to(CalculatorImpl.class);
        bind(UserDao.class).to(UserDaoImpl.class);
    }

    @Provides
    @Singleton
    public SqlSessionFactory createSQLSessionFactory() {
        URL resource = Main.class.getClassLoader().getResource("mydatabase.db");
        String path = null;

        {
            try {
                path = resource.toURI().getPath();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        String JDBCurl = ("jdbc:sqlite:" + path);

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(JDBCurl);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }
}



