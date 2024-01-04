package org.example.OOPInKotlin.abstractDifference

abstract class KotlinAnimal(
    // protected는 선언된 클래스와 서브클래스에서만 접근이 가능하다.
    // Java와 다른점은 Java는 같은 패키지에서도 접근이 가능하다.
    // final은 default이다. open을 붙여야 상속이 가능하다. (예시: 커스텀 getter를 사용할 때)
    private val species: String,
    protected open val legCount: Int
) {

    abstract fun move()

    fun getSpecies() = this.species
}