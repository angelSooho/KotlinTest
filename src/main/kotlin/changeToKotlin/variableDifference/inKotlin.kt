package org.example.changeToKotlin.variableDifference

fun main() {
//    var number1 = 10L
    var number1: Long = 10L
    number1 = 5L

//    val number2 = 10L
    val number2: Long = 10L
//    number2 = 5L  불가능

    println(number1)

    var number3: Long? = 1_000L
    number3 = null

//    var person = Person("이수호")
}