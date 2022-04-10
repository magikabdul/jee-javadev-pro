package pl.training.calculator.view;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.calculator.common.View;
import pl.training.calculator.controller.CalculatorController;

import java.util.Map;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ResultView implements View {

    private final CalculatorController calculatorController;

    @Override
    public void render(Map<String, Object> data) {
        System.out.println("Result: " + data.get("result"));
        calculatorController.showMenu();
    }

}
