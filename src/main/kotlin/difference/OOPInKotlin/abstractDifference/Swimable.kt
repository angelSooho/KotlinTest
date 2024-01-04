package org.example.OOPInKotlin.abstractDifference

interface Swimable {

    val swimAbility: Int // 추상 프로퍼티
    // 값을 직접 넣을 수도 있다.
    // val swimAbility: Int = 3

    fun act() {
        println("헤엄쳐서 이동합니다.")
    }
}