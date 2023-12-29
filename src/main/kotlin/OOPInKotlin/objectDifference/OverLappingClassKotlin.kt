package org.example.OOPInKotlin.objectDifference

fun main() {

}

class KotlinHouse(
    private val address: String,
    private val livingRoom: LivingRoom
) {

    // 내부 클래스 생성방법으로 권장되는 방법
    class LivingRoom(
        private var area: Double
    )

    // 내부 클래스 생성방법으로 권장되지 않는 방법
    inner class LivingRoom2(
        private var area: Double
    ) {
        // 내부 클래스에서 바깥 클래스의 프로퍼티에 접근하려면 inner 키워드를 붙여야 한다.
        // inner 키워드를 붙이지 않으면 컴파일 에러가 발생한다.
        val address: String
            get() = this@KotlinHouse.address
    }
}