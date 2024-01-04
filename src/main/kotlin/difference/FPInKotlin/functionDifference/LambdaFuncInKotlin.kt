package org.example.FPInKotlin.functionDifference

import difference.FPInKotlin.functionDifference.Fruit

fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 1_0000),
    )

    //  이름 없는 함수 람다 함수 lambda function
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 람다 함수
     val isApple2: (Fruit) -> Boolean = { fruit: Fruit ->
         fruit.name == "사과"
     }

    // invoke를 통해서 람다함수를 호출할 수 있다.
    // invoke는 생략이 가능하다.
    isApple.invoke(fruits[0])
    isApple(fruits[0])

    // 람다식에서 it는 람다식에서 사용되는 매개변수(파라미터)를 암시하는 키워드이다.
    // 람다식은 메소드의 파라미터로 전달할 수 있다.
    // 람다식은 파라미터이외에도 메소드 밖으로 빼서 작성할 수 있다.
    // inner
    // filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과" })
    // outer
    // filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
    val filterFruits = filterFruits(fruits) { it.name == "사과" }
    println(filterFruits.stream().map { it.name }.toList())
}

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val filteredFruits = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            filteredFruits.add(fruit)
        }
    }
    return filteredFruits
}

private fun filterFruites2(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    return fruits.filter(filter)
}