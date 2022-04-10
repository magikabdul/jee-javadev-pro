package pl.training.calculator.view;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.calculator.common.View;
import pl.training.calculator.controller.CalculatorController;

import java.util.Map;
import java.util.Scanner;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class MenuView implements View {

    private final CalculatorController calculatorController;
    private final Scanner scanner;

    @Override
    public void render(Map<String, Object> data) {
        System.out.println("Menu");
        System.out.println("1 - Dodaj");
        System.out.println("2 - Odejmij");
        System.out.println("3 - Wyjdź");
        calculatorController.execute(scanner.next());
    }

}
