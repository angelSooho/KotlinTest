package com.group.libraryapp.calculator

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class JunitCalculatorTest {

    @DisplayName("더하기 테스트")
    @Test
    fun addTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.add(3)

        //then
        assertThat(calculator.number).isEqualTo(8)
    }

    @DisplayName("빼기 테스트")
    @Test
    fun minusTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.minus(3)

        //then
        assertThat(calculator.number).isEqualTo(2)
    }

    @DisplayName("곱하기 테스트")
    @Test
    fun multiplyTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.multiply(3)

        //then
        assertThat(calculator.number).isEqualTo(15)
    }

    @DisplayName("나눗셈 테스트")
    @Test
    fun divideTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.divide(2)

        //then
        assertThat(calculator.number).isEqualTo(2)
    }

    @DisplayName("나눗셈 예외 테스트")
    @Test
    fun divideExceptionTest() {
        //given
        val calculator = Calculator(5)

        //when & then
        // assertThrows : 예외가 발생하는지 확인하는 함수
        // assertThrownBy와 assertThrows는 같은 기능을 한다.
        val message = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            calculator.divide(0)
        }.message

        assertThat(message).isEqualTo("0으로 나눌 수 없습니다.")
    }
}