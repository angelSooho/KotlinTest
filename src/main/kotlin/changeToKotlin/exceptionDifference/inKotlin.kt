package org.example.changeToKotlin.exceptionDifference

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val str = "123"
    val result1 = parseIntOrThrowV1(str)
    val result2 = parseIntOrThrowV2(str)
    println(result1)
    println(result2)
    readFileV1()
    readFileV2("a.txt")
}
private fun parseIntOrThrowV1(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다.")
    }
}

private fun parseIntOrThrowV2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

private fun readFileV1() {
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val bf = BufferedReader(FileReader(file))
    println(bf.readLine())
    bf.close()
}

private fun readFileV2(path: String) {
    BufferedReader(FileReader(path)).use { bf ->
        println(bf.readLine())
    }
}