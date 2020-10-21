import com.google.inject.AbstractModule;
import com.google.inject.Inject;

public class Application {

    private Calculator calculator;


    @Inject
    public Application(Calculator calculator) {
        this.calculator = calculator;
    }


    public void run() {
       System.out.println(calculator.addition(5,6));
    }
}
