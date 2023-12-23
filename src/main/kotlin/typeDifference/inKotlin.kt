package org.example.typeDifference

import domain.Person

fun main() {
//    val person = Person("이수호", 20)
//    printAgeIfPerson(person)
//    printAgeIfPerson("이수호")
//    printAgeIfPerson(123)

    val name = "이수호"

    val str = """
        안녕하세요.
        저는 $name 입니다.
        반갑습니다.
    """.trimIndent()
    println(str)

    val str2 = "ABC"
    println(str2[0])
    println(str2[1])
    println(str2[2])
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) { // 1. is ture | 2. !is false
        println(obj.age)
    }
    val person = obj as? Person // 1. as | 2. as?
    println(person?.age)
}