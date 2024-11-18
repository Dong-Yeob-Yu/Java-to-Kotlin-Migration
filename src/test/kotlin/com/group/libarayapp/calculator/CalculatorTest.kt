package com.group.libarayapp.calculator

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class CalculatorTest {

    @Test
    @DisplayName("더하기 테스트")
    fun addTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.add(10)

        // then
        assertEquals(15, calculator.number)
    }

    @Test
    @DisplayName("빼기 테스트")
    fun minus() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.minus(10)

        // then
        assertEquals(-5, calculator.number)
    }

    @Test
    @DisplayName("곱하기 테스트")
    fun multiply() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.multiply(5)

        // then
        assertEquals(25, calculator.number)
    }

    @Test
    @DisplayName("나누기 테스트")
    fun divide() {
        // given
        val calculator = Calculator(5)

        // then
//        assertFailsWith<IllegalArgumentException> {
//            calculator.divide(10)
//        }
    }


}