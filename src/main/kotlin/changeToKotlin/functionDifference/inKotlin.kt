package org.example.changeToKotlin.functionDifference

fun main() {
    val result1 = max(1, 2)
    val result2 = max(3, 4)
    println(result1)
    println(result2)

    repeat("Hello", 3, true)
    repeat("Hello")
    repeat("Hello", useNewLine = false) // named argument 이름 있는 인자

    printAll("Hello", "World", "Kotlin")

    val arr = arrayOf("Hello", "World", "Kotlin")
    printAll(*arr) // spread operator 전개 연산자 *arr -> "Hello", "World", "Kotlin"
}

private fun max(a: Int, b: Int) = if (a > b) a else b

fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printAll(vararg strs: String) {
    for (str in strs) {
        println(str)
    }
}