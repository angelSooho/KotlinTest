package org.example.nullDifference

import domain.Person

fun main() {
    var str: String? = "ABC"
//    str.length //안됨
    println(str?.length)
    str = null
    println(str?.length ?: 0)

//    val person = Person(("이수호"))
//    startWithA5(person.name)
}

fun startWithA1(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다.")
/*
if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다.")
    }
    return str.startsWith("A")
    */
}

fun startWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
    /*
    if (str == null) {
        return null
    }
    return str.startsWith("A")
    */
}

fun startWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
    /*
    if (str == null) {
        return false
    }
    return str.startsWith("A"
    )*/
}

fun startWithA4(str: String?): Boolean {
    return str!!.startsWith("A")
}

fun startWithA5(str: String): Boolean {
    return str.startsWith("A")
}