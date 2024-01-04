package org.example.OOPInKotlin.classDifference

import difference.OOPInKotlin.classDifference.JavaPerson

fun main() {
    // KotlinPerson 클래스는 코틀린으로 작성된 클래스이다.
    val personInKotlin1 = KotlinPerson("이수호", 25)
    println("--------------------")
    val personInKotlin2 = KotlinPerson("이수호")
    println("--------------------")
    val personInKotlin3 = KotlinPerson()

    println(personInKotlin1.name)
    println(personInKotlin1.age)
    personInKotlin1.age = 30
    println(personInKotlin1.age)

    println("--------------------")

    // JavaPerson 클래스는 자바로 작성된 클래스이다.
    val personInJava = JavaPerson("이수호", 25)

    println(personInJava.name)
    println(personInJava.age)
    personInJava.age = 30
    println(personInJava.age)
}