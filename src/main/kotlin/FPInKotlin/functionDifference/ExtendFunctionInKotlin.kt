package org.example.FPInKotlin.functionDifference

fun main() {
    val str = "Hello"
    // 모든 String형으로 선언된 변수는 String클래스의 확장함수를 사용할 수 있다.
    println(str.lastChar())
}

// String클래스의 확장함수
// this를 통해서 실제 클래스의 인스턴스에 접근할 수 있다.
fun String.lastChar(): Char {
    return this[this.length - 1]
}

fun