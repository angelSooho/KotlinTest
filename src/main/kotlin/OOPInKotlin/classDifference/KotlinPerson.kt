package org.example.OOPInKotlin.classDifference

// 주 생성자 (primary constructor) 반드시 클래스 선언부에 위치해야 한다.
// 단, 주 생성자에 파라미터가 하나도 없다면 생략 가능하다
class KotlinPerson(
    val name: String = "이수호",
    var age: Int = 25
) {
    /*
    * 주 생성자에서 받은 name을 불변 프로퍼티 name에 바로 대입
    * name에 대한 Custom getter를 만들때 field를 사용하여 프로퍼티에 접근할 수 있다.
    * field는 프로퍼티의 값을 저장하는 필드를 의미한다. (자바의 this.name) named ["backing field"]
    * 실무에서는 거의 사용하지 않는다.

    val name = name
        get() = field.uppercase()

    */

    fun getUppercaseName1() = this.name.uppercase()
    fun getUppercaseName2(): String {
        return this.name.uppercase()
    }

    var name2 = name
        // value는 프로퍼티에 대입되는 값이다.
        // field는 프로퍼티의 값을 저장하는 필드를 의미한다.
        // 역시나 실무에서는 거의 사용하지 않는다.
        // setter 자체를 자주 사용하지 않는다.
        set(value) {
            field = value.uppercase()
        }

    // 생성자에서 검증을 하고 싶다면 init 블록을 사용하면 된다.
    // 생성자가 호출되는 시점에 실행된다.
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 0보다 커야 합니다.")
        }
        println("주 생성자가 사용되었습니다.")
    }

    /**
     * 보조 생성자 (secondary constructor)
     * 반드시 있을 필요 없다.
     * 최종적으로 주 생성자를 호출해야 한다.
     * body를 가질 수 있다.
     * */
    constructor(name: String) : this(name, 25) {
        println("보조 생성자1가 사용되었습니다.")
    }

    // 보조 생성자는 여러 개를 가질 수 있다.
    constructor() : this("이수호") {
        println("보조 생성자2가 사용되었습니다.")
    }

    // 함수로 선언하여 사용할 수도 있다.
    fun isAdult1() = this.age >= 20
    fun isAdult2(): Boolean {
        return this.age >= 20
    }
    // getter를 커스텀 할 수도 있다.
    val isAdult3: Boolean
        get() = this.age >= 20

    // 객체의 속성이라면, custom getter 사용
    // 그렇지 않다면, 함수
    // custom getter 사용하면 자기 자신을 변경하여 반환할 수 있다.
}