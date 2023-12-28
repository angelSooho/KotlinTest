package org.example.OOPInKotlin.abstractDifference

class KotlinPenguin(
    species: String
) : KotlinAnimal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄은 두 발로 걷고, 두 날개로 헤엄칩니다.")
    }

    // Flyable 인터페이스의 act() 메서드를 오버라이드합니다.
    // 오버라이드를 할때 super 클래스에서 상속받는 프로퍼티는 open으로 선언되어야 합니다.
    // ex) protected open val legCount: Int
     override val legCount: Int
        get() = super.legCount + this.wingCount

    // Flyable과 Swimable 인터페이스의 act() 메서드를 오버라이드합니다.
    override fun act() {
        super<Flyable>.act()
        super<Swimable>.act()
    }

    // Swimable 인터페이스의 swimAbility 프로퍼티를 오버라이드합니다.
    override val swimAbility: Int
        get() = 3
}