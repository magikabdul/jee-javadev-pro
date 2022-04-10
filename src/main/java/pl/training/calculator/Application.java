package pl.training.calculator;

import org.jboss.weld.environment.se.Weld;
import pl.training.calculator.controller.CalculatorController;

public class Application {

    public static void main(String[] args) {
        var weld = new Weld();
        var container = weld.initialize();
        container.select(CalculatorController.class).get().showMenu();
        container.shutdown();
    }

}
