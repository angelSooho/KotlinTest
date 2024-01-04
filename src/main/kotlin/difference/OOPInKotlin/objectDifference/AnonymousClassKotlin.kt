package org.example.OOPInKotlin.objectDifference

import difference.OOPInKotlin.objectDifference.Movable

fun main() {
    // Java의 익명 클래스와 같은 역할을 하는 object 표현식
    // object 표현식은 object 표현식이 사용된 위치에서 생성된다.
    // java와의 차이점은 new 키워드가 없다는 것이다.
    moveSomething(object : Movable {
        override fun move() {
            println("I'm moving!")
        }

        override fun fly() {
            println("I'm flying!")
        }
    })

}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}