import com.google.inject.Guice;
import com.google.inject.Injector;

import java.net.URISyntaxException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, SQLException {
        Injector injector = Guice.createInjector(new GuiceModule());
        Application application = injector.getInstance(Application.class);
        application.run();
    }
}
