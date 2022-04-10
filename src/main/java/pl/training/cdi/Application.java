package pl.training.cdi;

import org.jboss.weld.environment.se.Weld;
import pl.training.calculator.controller.CalculatorController;

public class Application {

    public static void main(String[] args) {
        var weld = new Weld();
        var container = weld.initialize();
        container.select(TestBean.class).get().start();
        container.shutdown();
    }

}
