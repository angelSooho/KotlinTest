package org.example.EtcInKotlin

data class Person(
    val name: String,
    val age: Int,
)

class PersonComponentN(
    val name: String,
    val age: Int,
) {
    operator fun component1(): String {
        return this.name
    }

    // operator 키워드를 붙여야 한다.
    // 연산자의 속성을 가지는 메소드이기 때문이다.
    operator fun component2(): Int {
        return this.age
    }
}

fun main() {
    // 구조분해: 복합적인 값을 분해하여 여러 변수를 한 번에 초기화 하는 것
    val person = Person("이수호", 25)

    // name과 age를 한번에 초기화
    val (name, age) = person
    // 위를 풀어쓴다면,
    val nameC = person.component1()
    val ageC = person.component2()
    // 구조분해 문법을 쓴다는 것은 componentN 메소드를 사용한다는 것이다.

    println("${name} ${age}")
    println("${nameC} ${ageC}")


}