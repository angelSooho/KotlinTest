package org.example.FPInKotlin.collectionInFunc

data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long,
) {
    val List<Fruit>.samePriceFilter: List<Fruit>
        get() = this.filter(Fruit::isSamePrice)

    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice
}

fun main() {
    val fruits = listOf(
        Fruit(1, "사과", 1000, 1200),
        Fruit(2, "사과", 2000, 2400),
        Fruit(3, "바나나", 3000, 3600),
        Fruit(4, "바나나", 4000, 4800),
        Fruit(5, "멜론", 5000, 6000),
    )

    val apple1 = fruits.filter { fruit -> fruit.name == "사과" }
    println(apple1)

    // filterIndexed
    // index를 사용할 수 있다.
    val apples2 = fruits.filterIndexed { idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }
    println(apples2)

    // Map
    // filter와 map을 같이 사용할 수 있다.
    val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.currentPrice }
    println(applePrices)

    // mapNotNull
    // null이 아닌 값만 반환한다.
//    val values = fruits.filter { fruit -> fruit.name == "사과" }
//        .mapNotNull { fruit -> fruit.nullOrValue() }

    // all
    // 모든 요소가 조건을 만족하는지 확인한다.
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }

    // none
    // 모든 요소가 조건을 만족하지 않는지 확인한다.
    val isNoneApple = fruits.none { fruit -> fruit.name == "사과" }

    // any
    // 하나라도 조건을 만족하는지 확인한다.
    val isAnyApple = fruits.any { fruit -> fruit.name == "사과" }

    // sortedBy
    // 오름차순으로 정렬한다.
    val fruitCount = fruits.sortedBy { fruit -> fruit.currentPrice }

    // sortedByDescending
    // 내림차순으로 정렬한다.
    val fruitCount2 = fruits.sortedByDescending { fruit -> fruit.currentPrice }

    // distinctBy
    // 중복을 제거한다.
    val distinctFruits = fruits.distinctBy { fruit -> fruit.name }.map { fruit -> fruit.name }

    // first
    // 첫번째 요소를 반환한다.
    val firstFruit = fruits.first()

    // firstOrNull
    // 첫번째 요소를 반환한다. 없으면 null을 반환한다.
    val firstFruit2 = fruits.firstOrNull()

    // last
    // 마지막 요소를 반환한다.
    val lastFruit = fruits.last()

    // lastOrNull
    // 마지막 요소를 반환한다. 없으면 null을 반환한다.
    val lastFruit2 = fruits.lastOrNull()

    // List -> Map
    // 과일이름 -> List<과일>로 변환한다.
    // groupBy
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }

    // List -> Map
    // id -> 과일로 변환한다.
    // associateBy
    val map2: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }

    // List -> Map
    // 과일이름 -> List<출고가>로 변환한다.
    val map3: Map<String, List<Long>> = fruits.groupBy({ fruit -> fruit.name }, { fruit -> fruit.factoryPrice })

    // List -> Map
    // id -> 출고가
    val map4: Map<Long, Long> = fruits.associateBy({ fruit -> fruit.id }, { fruit -> fruit.factoryPrice })

    // List -> Map
    // 과일이름이 사과인 것만 필터링한다.
    val map5: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }.filter {(key, value) -> key == "사과" }

    // 중첨 컬렉션 처리
    val fruitsInList: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1, "사과", 1000, 1200),
            Fruit(2, "사과", 2000, 2400),
            Fruit(3, "바나나", 3000, 3600),
            Fruit(4, "바나나", 4000, 4800),
            Fruit(5, "멜론", 5000, 6000),
        ),
        listOf(
            Fruit(6, "사과", 1000, 1200),
            Fruit(7, "사과", 2000, 2400),
            Fruit(8, "바나나", 3000, 3600),
            Fruit(9, "바나나", 4000, 4800),
            Fruit(10, "멜론", 5000, 6000),
        ),
        listOf(
            Fruit(11, "사과", 1000, 1200),
            Fruit(12, "사과", 2000, 2400),
            Fruit(13, "바나나", 3000, 3600),
            Fruit(14, "바나나", 4000, 4800),
            Fruit(15, "멜론", 5000, 6000),
        ),
    )

    // flatMap
    // 출고가와 현재가가 동일한 과일
    val samePriceFruits = fruitsInList.flatMap { list -> list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice } }

    // refactoring
//    val samePriceFruitsRefactor = fruitsInList.flatMap { list -> list.samePriceFilter }

    // flatten
    // 중첩 컬렉션을 평평하게 만든다.
    val flattenFruits = fruitsInList.flatten()

}