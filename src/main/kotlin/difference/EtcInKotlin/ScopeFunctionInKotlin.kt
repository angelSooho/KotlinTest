package org.example.EtcInKotlin

fun main() {
    // scope function: 일시적인 영역을 형성하는 함수
    // 람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나, method chaining에 활용하는 함수를 scope function이라고 한다.

    // this: 생략이 가능한 대신, 다른 이름을 붙일 수 없다.
    // it: 생략이 불가능한 대신, 다른 이름을 붙일 수 있다.

    val person = Person("이수호", 25)
    val str: String? = "apple"
    // let: 람다식의 결과를 반환한다.
    // 1. 하나 이상의 함수를 call chain 결과로 호출할 때 사용
    // 2. non-null 값에 대해서만 code black을 실행시킬 때
    // 일회성으로 제한된 영역에지역 변수를 만들 때 (자주 사용하지 않음. private 함수를 만들어서 사용하는 것이 좋다.)
    val value1 = str?.let {
        println(it.uppercase())
        it.length
    }

    val strings = listOf("APPLE", "CAR")
    // 1
    strings.map { it.length }
        .filter { it > 3 }
        .let(::println)
    // 2
    strings.map { it.length }
        .filter { it > 3 }
        .let { lengths -> println(lengths) }


    // run: 람다식의 결과를 반환한다.
    // run은 let과 다르게 this를 사용할 수 있다.
    // 1. 객체를 만들어 DB에 바로 저장하고, 그 인스턴스를 활용할 때
    // ex 1) val person = Person("이수호", 25).run(personRepository::save)
    /**
     * ex 2)
     * val person = Person("이수호", 25).run {
     * hobby = "soccer"
     * personRepository.save(this)
     * 개발자 별로 나뉘어 사용한다고 함
     * 일단 익숙하지 않고, 반복되는 생성 후처리는 생성자, 프로퍼티, init block으로 넣는 것이 좋다.
     * */
    val value2 = person.run {
        this.age
    }
    // also: 람다식의 결과가 어떻든 객체를 반환한다.
    // 1. 객체를 수정하는 로직이 call chain 중간에 필요할 때
    mutableListOf("one", "two", "three")
        .also { println("four 추가 이전 지금 값: ${it}") }
        .add("four")
    val value3 = person.also {
        it.age
    }
    // apply: 람다식의 결과가 어떻든 객체를 반환한다.
    // apply는 also와 다르게 this를 사용할 수 있다.
    // 1. 객체 설정을 할 때에 객체를 수정하는 로직이 call chain 중간에 필요할 때 (test Fixture를 만들 때)
    /**
     * fun createPerson(
     * name: String,
     * age: Int,
     * hobby: String,
     * ): Person {
     * return Person(
     * name = name,
     * age = age,
     * ).apply {
     * this.hobby = hobby
     * }
     * ex) Person("이수호", 25).apply { hobby = "soccer" }
     * */
    val value4 = person.apply {
        this.age
    }
    // with
    // 확장 함수가 아니다.
    // with는 this를 사용할 수 있다. 그리고 this를 생략할 수 있다.
    // 1. 특정 객체를 다른 객체로 변환해야 하는데, 모듈간의 의존성에 의해
    // 정적 팩토리 혹은 toClass 함수를 만들기 어려울 때
    /*
    return with(person) {
        PersonDto(
            name = this.name,
            age = this.age,
        )
    }
    */


    /**
     * let: 하나 이상의 함수를 call chain 결과로 호출할 때 사용
     *
     * */
}

fun printPerson(person: Person?) {
    if (person != null) {
        println(person.name)
        println(person.age)
    }

    // refactor
    person?.let {
        println(it.name)
        println(it.age)
    }
    // let은 람다식의 결과를 반환한다.
    // 람다식의 결과가 없으면 Unit을 반환한다.
    // Safe Call(?.)과 함께 사용하면 null이 아닐 때만 실행된다.
}