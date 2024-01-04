package org.example.rangeDufference

fun main() {

    // range 0 to 10 UP
    for (i in 1..10) {
        print("${i} ")
    }

    println()

    // range 10 to 0 DOWN
    for (i in 10 downTo 1) {
         println(i)
    }

    println()

    // range 0 to 10 step 2
    for(i in 0..10 step 2) {
        println(i)
    }

    // while 1 to 3
    var i = 1;
    while (i <= 3) {
        println(i)
        i++;
    }

}