package org.example.OOPInKotlin.abstractDifference

class KotlinCat(
    species: String,
) : KotlinAnimal(species, 4) {

    override fun move() {
        println("고양이는 네 발로 걷습니다.")
    }
}