package pl.training.calculator.model;

import java.math.BigDecimal;

public class Calculator {

    public BigDecimal add(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.add(secondValue);
    }

    public BigDecimal subtract(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.subtract(secondValue);
    }

}
