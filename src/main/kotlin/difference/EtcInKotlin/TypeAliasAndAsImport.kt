package org.example.EtcInKotlin

import org.example.EtcInKotlin.B.printHelloWorld as printHelloWorldB
import org.example.EtcInKotlin.A.printHelloWorld as printHelloWorldA
import org.example.FPInKotlin.collectionInFunc.Fruit

fun main() {
    // as import
    // 같은 이름의 함수를 사용할 때는 as import를 통해서 구분할 수 있다.
    printHelloWorldA()
    printHelloWorldB()
}

// typealias
typealias FruitFilter = (Fruit) -> Boolean

// typealias를 사용하면 함수의 파라미터로 함수를 전달할 때
// 함수의 파라미터의 타입을 간결하게 표현할 수 있다.
fun filterFruits(fruits: List<Fruit>, filter: FruitFilter) {
}

data class UltraSuperGuardianTribe(
    val name: String
)

// 이름이 긴 클래스를 컬렉션에 사용할 떄도 간단히 표현할 수 있다.
typealias USGTMap = Map<String, UltraSuperGuardianTribe>

