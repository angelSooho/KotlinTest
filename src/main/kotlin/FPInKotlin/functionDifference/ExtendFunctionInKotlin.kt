package org.example.FPInKotlin.functionDifference

import FPInKotlin.functionDifference.FuncJavaPerson


fun main() {
    val str = "Hello"
    // 모든 String형으로 선언된 변수는 String클래스의 확장함수를 사용할 수 있다.
    println(str.lastChar())

    val person = FuncJavaPerson("Kotlin",  "B", 31)
    println(person.nextYearAge())


    val train: Train = Train()
    train.isExpensive()

    // Train의 확장함수가 아닌 Srt의 확장함수가 호출된다.
    // 확장함수는 정적으로 결정되기 때문에, 변수의 타입이 아닌 인스턴스의 타입을 기준으로 확장함수가 결정된다.
    // 내부 구현체가 아닌 인스턴스의 타입을 기준으로 확장함수가 결정된다.
    val str1: Train = Srt()
    str1.isExpensive()

    val str2: Srt = Srt()
    str2.isExpensive()
}

// String클래스의 확장함수
// this를 통해서 실제 클래스의 인스턴스에 접근할 수 있다.
fun String.lastChar(): Char {
    return this[this.length - 1]
}

fun FuncJavaPerson.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

open class Train(
    val name: String = "새마을 기차",
    val price: Int = 5_000,
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return this.price >= 10_000
}

class Srt : Train("SRT", 40_000)

fun Srt.isExpensive(): Boolean {
    println("Srt의 확장함수")
    return this.price >= 10_000
}

//fun String.lastChar(): Char {
//    return this[this.length - 1]
//}

// 확장함수를 프로퍼티로 사용할 수 있다.
val String.lastChar: Char
    get() = this[this.length - 1]

fun Int.add(other: Int): Int {
    return this + other
}

// 중위 함수 = infix fun
// 중위 함수는 인자가 하나뿐인 메소드나 확장함수에 사용할 수 있다.
// 함수를 호출하는 새로ㅓ운 방법
// 기존에는 변수.함수이름(argument)로 호출했지만, 중위 함수는 변수 함수이름 argument로 호출할 수 있다.
// ex) 1.add2(2)
infix fun Int.add2(other: Int): Int {
    return this + other
}

// inline fun = 인라인 함수
// 인라인 함수는 함수를 호출하는 것이 아니라, 함수의 내용을 호출하는 곳에 복사해 넣는다.
// 중위 함수와 차이점은 인자가 하나뿐인 메소드나 확장함수에 사용할 수 있다.
inline fun Int.add3(other: Int): Int {
    return this + other
}
