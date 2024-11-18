package com.group.libarayapp.calculator

class Calculator(
    var number: Int,
) {

    // 더하기
    fun add(operand: Int){
        this.number += operand
    }

    // 빼기
    fun minus(operand: Int){
        this.number -= operand
    }

    // 곱하기
    fun multiply(operand: Int){
        this.number *= operand
    }

    // 나누기
    fun divide(operand: Int) {
        if (operand == 0) {
            throw IllegalArgumentException("Division by zero")
        }
        this.number /= operand
    }
}