package com.group.libraryapp.calculator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class JunitCalculatorTest {

    @DisplayName("예외 테스트")
    @Test
    fun 예외_테스트(){
        //given
        val calculator = Calculator(10)

        //when
        val message = assertThrows<IllegalArgumentException> {
            calculator.divide(0)
        }.message


        //then
        Assertions.assertEquals("Division by zero", message)

    }

}