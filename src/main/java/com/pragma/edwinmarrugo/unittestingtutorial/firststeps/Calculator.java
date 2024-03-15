package com.pragma.edwinmarrugo.unittestingtutorial.firststeps;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public static int sum(int number1, int number2){
        return number1 + number2;
    }
    public static double divide(double number1, double number2) {
        if (number2 == 0){
            throw new IllegalArgumentException("No existe la division por 0");
        }
        double result = number1 / number2;
        BigDecimal bd = BigDecimal.valueOf(result);
        BigDecimal numeroRedondeado = bd.setScale(2, RoundingMode.HALF_UP);
        return numeroRedondeado.doubleValue();
    }
}
