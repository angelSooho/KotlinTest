package org.example.EtcInKotlin

fun main() {
    // takeIf
    // takeIf는 람다식의 결과가 true일 때 결과를 반환한다.
    // false일 때는 null을 반환한다.
    val a = 10
    val b = 20
    val max = a.takeIf { a > b } ?: b
    println(max)

    // takeUnless
    // takeUnless는 람다식의 결과가 false일 때 결과를 반환한다.
    // true일 때는 null을 반환한다.
    val min = a.takeUnless { a > b } ?: b
    println(min)
}

fun getNumberOrNull(): Int? {
    val number = 10
    return if (number <= 0) {
        null
    } else {
        number
    }

    // takeIf를 사용하면 위의 코드를 아래와 같이 작성할 수 있다.
    // takeIf는 람다식의 결과가 true일 때 결과를 반환한다.
    // 주어진 조건을 만족하면 값이, 그렇지 않으면 null이 반환된다.
    return number.takeIf { it > 0 }
}

fun getNumberOrNull2(): Int? {
    val number = 10
    // takeUnless를 사용하면 위의 코드를 아래와 같이 작성할 수 있다.
    // takeUnless는 람다식의 결과가 false일 때 결과를 반환한다.
    // 주어진 조건을 만족하지 않으면 값이, 그렇지 않으면 null이 반환된다.
    return number.takeUnless { it <= 0 }
}