package com.group.libraryapp.calculator

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

    @DisplayName("나누기 테스트")
    @Test
    fun divideExceptionTest(){
        //gvien
        val calculator = Calculator(5)

        //when
        try {
            calculator.divide(0);
        } catch (e: IllegalArgumentException) {
            if(e.message != "Division by zero") {
                throw IllegalArgumentException("예외 메시지가 다릅니다.")
            }
            //테스트 성공 !
            return
        } catch (e: RuntimeException){
            throw IllegalArgumentException()
        }

        throw IllegalArgumentException("기대하는 예외가 발생하지 않았음")

        //then


    }

}