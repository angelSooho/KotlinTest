package org.example.OOPInKotlin.objectDifference

import difference.OOPInKotlin.objectDifference.JavaPerson

fun main() {

    println(Singleton.a)
    Singleton.a = 10
    println(Singleton.a)

}

class KotlinPerson private constructor(
    var name: String,
    var age: Int,
){

    // Java의 static method와 같은 역할을 하는 companion object
    // 클래스와 동행하는 유일한 객체(object)이다.


    companion object {
        // val만 있으면 런타임시에 초기화
        // const val만 있으면 컴파일시에 초기화
        // 진짜 상수로 사용하고 싶다면 const val을 사용하자.
        private val MIN_AGE = 1

        // @JvmStatic 어노테이션을 붙이면 자바에서의 static 메소드처럼 사용할 수 있다.
        // Companion 없이
        @JvmStatic
        fun newBaby(name: String): KotlinPerson {
            return KotlinPerson(name, MIN_AGE)
        }
    }
}

// 실무에서는 직접적으로 사용할 일은 많지 않다고 한다.
// 싱글톤 객체 생성 방법
object Singleton {
    var a: Int = 0
}