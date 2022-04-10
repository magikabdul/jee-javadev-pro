package pl.training.calculator.controller;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.calculator.model.Calculator;
import pl.training.calculator.common.Controller;
import pl.training.calculator.common.ModelAndView;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CalculatorController {

    private final Calculator calculator;

    public ModelAndView showMenu() {
        return new ModelAndView("Menu");
    }

    public ModelAndView execute(String option) {
        return switch (option) {
            case "1" -> new ModelAndView("AddValues");
            case "2" -> new ModelAndView("SubtractValues");
            case "3" -> new ModelAndView("Exit");
            default -> throw new IllegalStateException();
        };
    }

    public ModelAndView addValues(BigDecimal firstNumber, BigDecimal secondNumber) {
        var result = calculator.add(firstNumber, secondNumber);
        return new ModelAndView("Result", Map.of("result", result));
    }

    public ModelAndView subtractValues(BigDecimal firstNumber, BigDecimal secondNumber) {
        var result = calculator.subtract(firstNumber, secondNumber);
        return new ModelAndView("Result", Map.of("result", result));
    }

}
