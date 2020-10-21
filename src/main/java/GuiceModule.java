import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Calculator.class).to(CalculatorImpl.class);
    }

}
