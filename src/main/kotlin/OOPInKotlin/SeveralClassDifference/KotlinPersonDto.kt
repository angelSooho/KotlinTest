package org.example.OOPInKotlin.SeveralClassDifference

fun main() {
    val dto1 = KotlinPersonDto("이수호", 100)
    val dto2 = KotlinPersonDto("김채원", 200)
    val sameDto1 = KotlinPersonDto("이수호", 100)
    println(dto1 == dto2)

    // 자동으로 생성된 equals() 메소드를 통해
    // dto1과 sameDto1은 같은 객체임을 알 수 있다.
    println(dto1 == sameDto1)
    println(dto1)
}

// data 클래스로 생성된 클래스는
// equals(), hashCode(), toString(), copy() 메소드를 자동으로 생성해준다.
// builder도 자동으로 생성해준다.
// java에서는 jdk 16부터 record라는 기능이 추가되었다.
data class KotlinPersonDto(
    val name: String,
    val age: Int,
)