package com.pragma.edwinmarrugo.unittestingtutorial.firststeps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void deberiaCalcularLaSumaDeDosNumeros() {
        //GIVEN
        int number1 = 3;
        int number2 = 2;

        //WHEN
        int result = Calculator.sum(number1, number2);

        //THEN
        assertThat(result).isEqualTo(5);
    }

    @Test
    void deberiaCalcularLaDivisionDeDosNumerosCuandoElDividendoEsMayorQueElDivisor() {
        //GIVEN
        int number1 = 10;
        int number2 = 5;
        //WHEN
        double result = Calculator.divide(number1, number2);
        //THEN
        assertThat(result).isEqualTo(2);
    }
    @Test
    @DisplayName("deberia calcular la division de dos numeros cuando el dividendo es menor que el divisor")
    void divisionConDividendoMenorQueElDivisor() {
        //GIVEN
        int number1 = 10;
        int number2 = 12;
        //WHEN
        double result = Calculator.divide(number1, number2);

        //THEN
        assertThat(result).isEqualTo(0.83);
    }
    @Test
    @DisplayName("deberia calcular la division de dos numeros cuando el dividendo es menor que el divisor y el divisor es negativo")
    void divisionConDividendoMenorQueElDivisorYDivisorNegativo() {
        //GIVEN
        int number1 = 10;
        int number2 = -12;
        //WHEN
        double result = Calculator.divide(number1, number2);

        //THEN
        assertThat(result).isEqualTo(-0.83);
    }
    @Test
    @DisplayName("deberia lanzar una excepcion cuando el divisor es igual a 0")
    void divisionConDivisorIgualACero() {
        //GIVEN
        int number1 = 10;
        int number2 = 0;
        //THEN
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(number1, number2) /*WHEN*/);
    }
}