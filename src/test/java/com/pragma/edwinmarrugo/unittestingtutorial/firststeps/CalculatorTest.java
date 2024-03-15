package com.pragma.edwinmarrugo.unittestingtutorial.firststeps;

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
}