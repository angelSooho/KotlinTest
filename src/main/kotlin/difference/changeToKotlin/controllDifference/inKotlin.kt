package org.example.changeToKotlin.controllDifference

fun main() {
    val score = 90
//    validateScoreIsNotNegative(score)
//    validateScoreIsNotNegative(101)
//    validateScoreIsNotNegative(-1)
    val gradeWithSwitch = getGradeWithSwitch(score)
    println("Grade is ${gradeWithSwitch}")
}

fun validateScoreIsNotNegative(score: Int) {
//    if (score < 0) {
//        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
//    }
//    println("Score is ${score}")
    if (score !in 0..100) {
        throw IllegalArgumentException("${score}는 0보다 작거나 100보다 클 수 없습니다.")
    }

    if (score in 0..100) {
        println("Score is ${score}")
    }
}

fun getPassOrFail(score: Int): String {
    return if (score >= 80) {
        "Pass"
    } else {
        "Fail"
    }
}

fun getGrade(score: Int): String {
    return when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }
}

fun validate(score: Int): String {
    return when {
        score >= 80 -> "Pass"
        score < 0 -> "Invalid Score"
        else -> "Fail"
    }
}

fun getGradeWithSwitch(score: Int): String {
    return when(score / 10) {
        10, 9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "F"
    }
}

// Any는 Java의 Object와 비슷한 역할을 한다.
fun startsWithA(str: Any): Boolean {
    return when(str) {
        // is는 Java의 instanceof와 비슷한 역할을 한다.
        is String -> str.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int) {
    return when(number) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("1, 0, -1이 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}