package org.example.FPInKotlin.collectionDifference

fun main() {
    // 불변 리스트
    val numbers = listOf(1, 2, 3, 4, 5)
    val emptyList = emptyList<Int>()

    // 불변 리스트는 추가가 안된다.
//    numbers.add(6)

    // 가변 리스트
    val mutableList = mutableListOf(100, 200)
    mutableList.add(300 )

//    println(printNumbers(numbers))

    // Java의 get이 없어도 출력이 바로 된다.
    // get() -> []
    println(numbers[0])

    for (number in numbers) {
        println(number)
    }

    for((idx, value) in numbers.withIndex()) {
        println("${idx} ${value}")
    }

    // 불변 셋
    val numberSet = setOf(1, 2, 3, 4, 5)

    // 가변 셋
    val mutableSet = mutableSetOf(100, 200)
    mutableSet.add(300)

    for (number in numberSet) {
        println(number)
    }

    // 불변 맵
    val numberMap = mapOf(
        1 to "one",
        2 to "two",
        3 to "three",
    )

    // 가변 맵
    // 타입을 명시해줘야 한다.
    val map = mutableMapOf<Int, String>()
    map[1] = "one"
    map[2] = "two"

    val mutableMap = mutableMapOf(
        1 to "one",
        2 to "two",
        3 to "three",
    )
    mutableMap.put(4, "four")
    // mutableMap[4] = "four" 와 같이 사용할 수 있다.
    mutableMap[5] = "five"

    for ((key, value) in mutableMap.entries) {
        println("${key} ${value}")
    }

    for (key in mutableMap.keys) {
        println("${key} ${mutableMap[key]}")
    }

    /**
     * List<Int?> -> 리스트에 null이 들어갈 수 있지만, 리스트는 절대 null이 아니다
     * List<Int>? -> 리스트에는 null이 들어갈 수 없지만, 리스트는 null일 수 있다
     * List<Int?>? -> 리스트에 null이 들어갈 수 있고, 리스트 자체도 null일 수 있다
     * */
    // 리스트가 Kotlin -> Java로 가져와서 사용된다면
    // Kotlin에서 생성된 리스트는 nullable, non-nullable이 구분되지만
    // Java에서는 구분이 되지 않기때문에 문제가 발생할 수 있다.
    // 띠리사 코틀린쪽에서 Collections.unmodifiableList()를 사용해서
    // 변경 불가능한 리스트로 만들어서 막을 수 있다.
}

private fun printNumbers(numbers: List<Int>) {
    for (number in numbers) {
        println(number)
    }
}