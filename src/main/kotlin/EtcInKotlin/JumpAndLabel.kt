package org.example.EtcInKotlin

fun main() {
    /**
     * Kotlin에서의
     * return : 기본적으로 가장 가까운 enclosing function 또는 익명함수로 값이 반환된다.
     * break : 가장 가까운 루프가 제거된다.
     * continue : 가장 가까운 루프를 다음 step으로 보낸다.
     * */

    val numbers = listOf(1, 2, 3, 4, 5)
    numbers.map { number -> number + 1 }
        .forEach { number -> println(number) }

    // break -> run
    // 스트림 API를 사용할 때, 내부에 break를 사용하고 싶다면 run을 사용하면 된다.
    run {
        numbers.forEach { number ->
            if (number == 3) {
                return@run
            }
            println(number)
        }
    }

    // continue -> forEach
    // 스트림 API를 사용할 때, 내부에 continue를 사용하고 싶다면 forEach를 사용하면 된다.
    numbers.forEach { number ->
        if (number == 3) {
            return@forEach
        }
        println(number)
    }

    // 하지만 위 두 가지 방법은 잘 사용하지 않는다.
    // 따라서, brak, continue를 사용할 때엔, 가급적 인숙한 for문을 사용하는 것이 좋다.

    // label
    // label을 사용하면, break, continue를 사용할 때, label을 사용할 수 있다.
    // label은 @를 붙여서 사용한다.
    // label은 함수의 이름과 동일하게 작성하는 것이 좋다.

    // loop 라벨을 사용한 아래와 같은 경우, 기본적으로 break는 break가 사용된 가장 가까운 for문을 나오게 되지만,
    // loop@를 사용하면, loop@가 사용된 가장 가까운 for문을 나오게 된다.
    // 이때 라벨의 이름은 임의로 지정할 수 있다. loop는 임의로 지정한 라벨이다.
    // 하지만 최대한 목적에 맞게 지정하는 것이 좋다.
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (j == 2) {
                break@loop
            }
            println("i : $i, j : $j")
        }
    }
    // 하지만 label을 사용한 Jump는 사용하지 않는 것이 좋다.
    // label을 사용하면, 코드의 가독성이 떨어지기 때문이다.
    // 유지보수성이 떨어진다.


}