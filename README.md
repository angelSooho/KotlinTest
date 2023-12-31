# Kotlin Package 정리

- ChangeToKotlin
  - controll
    - range -> in
    - return: 코틀린에서 return은 표현식(expression)이기 때문에 값을 반환할 수 있다.
      - `return if (a > b) a else b`
      - `return when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
        }`
      - `return when {
        score >= 80 -> "Pass"
        score < 0 -> "Invalid Score"
        else -> "Fail"
        }`
      - `return when(score / 10) {
        10, 9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "F"
        }`
      - `when {
        number == 0 -> println("주어진 숫자는 0입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
        }`
    - instanceof -> is
      - `return when(str) {
        // is는 Java의 instanceof와 비슷한 역할을 한다.
        is String -> str.startsWith("A")
        else -> false
        }`
    - `return try {
      str.toInt()
      } catch (e: NumberFormatException) {
      null
      }`
    - for문에서 범위는 `in`을 사용한다.
      - `for (i in 1..10) { ... }`
      - `for (i in 1 until 10) { ... }`
      - `for (i in 2..10 step 2) { ... }`
      - `for (i in 10 downTo 1) { ... }`
      - `for (i in 10 downTo 1 step 2) { ... }`
    - null값의 표현은 `?`을 사용한다.
      - `var str: String? = "Hello Kotlin"`
      - `str = null`
      - `println("str: $str length: ${str?.length}")`
      - `println("str: $str length: ${str?.length ?: -1}")`
      - `println("str: $str length: ${str!!.length}")`
      - `fun startWithA1(str: String?): Boolean {
        return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다.")` // 마치 Java의 Optional처럼 사용할 수 있다.
- OOPInKotlin
  - 생성자
    - `class Person1 constructor(name: String, age: Int) { ... }`
    - 따로 constructor를 명시하지 않으면 기본 생성자가 만들어진다.
    - Java처럼 메소드를 생성하지 않고, ()안에 필드를 선언하면 생성자, getter, setter가 만들어진다.
  - 상속
    - `class KotlinCat(
      species: String,
      ) : KotlinAnimal(species, 4)`
    - abstract 키워드 사용은 Java와 동일하다.
    - protected 필드는 `open` 키워드를 붙여야 상속이 가능하다. (커스텀 getter를 사용할 때)
  - 오버라이드
    - `override` 키워드 사용은 Java와 동일하다.
    - 그러나 어노테이션이 아닌 메소드 앞에 `override` 키워드를 붙여야 한다.
    - `override fun eat() { ... }`
  - getter
    - `val name: String = "Kotlin"` // getter가 자동으로 만들어진다.
    - custom getter
      - `val name: String
        get() = "Kotlin"`
  - setter
    - `var age: Int = 0 // setter가 자동으로 만들어진다.`
    - custom setter
      - `var age: Int = 0
        set(value) {
        field = if (value >= 0) value else 0
        }`
  - object 키워드
    - companion object
      - java의 static과 비슷하다.
      - `companion object {
        val TAG: String = "KotlinCat"
        fun create(): KotlinCat = KotlinCat("cat")
        }`
      - Java와 다르게 클래스당 하나만 존재할 수 있다.
      - 오브젝트 내부에 여러 메소드를 정의할 수 있다.
  - enum
    - `enum class KotlinCountry(
      private val code: String,
      ) {
      KOREA("KO"),
      AMERICA("US");
      }`
    - `fun handleCountry(country: KotlinCountry) {
      // when은 enum class에서 자주 사용된다.
      when (country) {
      KotlinCountry.KOREA -> TODO()
      KotlinCountry.AMERICA -> TODO()
      }
      }`
      - when은 enum class에서 자주 사용된다.
  - sealed class
    - `sealed class KotlinSealedClass {
      class KotlinSealedClass1 : KotlinSealedClass()
      class KotlinSealedClass2 : KotlinSealedClass()
      }`
    - enum과 다른점은 단일 클래스를 받는 것이 아닌 여러 클래스를 받을 수 있다.
  - data class
    - `data class KotlinDataClass(
      val name: String,
      val age: Int,
      )`
    - data class는 toString(), equals(), hashCode(), copy() 메소드를 자동으로 만들어준다.
    - data class는 주로 DTO로 사용된다.
- FPInKotlin
  - collection
    - Array
      - `val arr = arrayOf(1, 2, 3)`
      - indices
        - `for (i in arr.indices) { ... }`
          - `for (i in array.indices) {
            println("${i} ${array[i]}")
            }`
      - withIndex()
        - `for ((index, value) in arr.withIndex()) { ... }`
          - `for ((index, value) in array.withIndex()) {
            println("${index} ${value}")
            }`
    - Collection
      - `val list = listOf(1, 2, 3)` // 불변 리스트
      - `val mutableList = mutableListOf(1, 2, 3)` // 가변 리스트
      - `val set = setOf(1, 2, 3)` // 불변 셋
      - `val mutableSet = mutableSetOf(1, 2, 3)` // 가변 셋
      - `val map = mapOf("a" to 1, "b" to 2, "c" to 3)` // 불변 맵
      - `val map = mutableMapOf<Int, String>()
        map[1] = "one"
        map[2] = "two"`
      - `val mutableMap = mutableMapOf("a" to 1, "b" to 2, "c" to 3)` // 가변 맵
    - Collection Function
      - filterIndexed
        - index를 사용할 수 있다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val filteredList = list.filterIndexed { index, value ->
          index % 2 == 0
          }`
      - Map
        - filter와 map을 같이 사용할 수 있다.
        - `val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
          .map { fruit -> fruit.currentPrice }
          println(applePrices)`
      - mapNotNull
        - null이 아닌 값만 반환한다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val newList = list.mapNotNull { value ->
          if (value % 2 == 0) {
          value * 2
          } else {
          null
          }
          }`
      - all
        - 모든 요소가 조건을 만족하는지 확인한다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val allEven = list.all { value -> value % 2 == 0 }`
      - any
        - 하나라도 조건을 만족하는지 확인한다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val anyEven = list.any { value -> value % 2 == 0 }`
      - none
        - 모든 요소가 조건을 만족하지 않는지 확인한다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val noneEven = list.none { value -> value % 2 == 0 }`
      - sortedBy
        - 오름차순으로 정렬한다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val sortedList = list.sortedBy { value -> value % 2 }`
      - sortedByDescending
        - 내림차순으로 정렬한다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val sortedList = list.sortedByDescending { value -> value % 2 }`
      - distinctBy
        - 중복을 제거한다.
        - `val list = listOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
          val distinctList = list.distinctBy { value -> value % 2 }`
      - first
        - 첫번째 요소를 반환한다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val first = list.first()`
      - firstOrNull
        - 첫번째 요소를 반환한다. 없으면 null을 반환한다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val first = list.firstOrNull()`
      - last
        - 마지막 요소를 반환한다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val last = list.last()`
      - lastOrNull
        - 마지막 요소를 반환한다. 없으면 null을 반환한다.
        - `val list = listOf(1, 2, 3, 4, 5)
          val last = list.lastOrNull()`
      - List -> Map
        - 과일이름 -> List<과일>로 변환한다.
        - groupBy
          - `val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }`
        - id -> 과일로 변환한다.
        - associateBy
          - `val map: Map<Int, Fruit> = fruits.associateBy { fruit -> fruit.id }`
      - flatMap
        - 출고가와 현재가가 동일한 과일
        - `val samePriceFruits = fruitsInList.flatMap { list -> list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice } }`
      - flatten
        - 중첩 컬렉션을 평평하게 만든다.
        - `val flattenFruits = fruitsInList.flatten()`
    - ExtendFunctionInKotlin
    - 확장함수는 클래스의 멤버 메소드처럼 호출할 수 있지만, 클래스의 멤버 메소드는 아니다. ex) 변수.메소드
      - `fun String.lastChar(): Char = this.get(this.length - 1)`
      - `fun String.lastChar(): Char = get(length - 1)`
      - `fun String.lastChar(): Char = get(lastIndex)`
      - `open class Train(
        val name: String = "새마을 기차",
        val price: Int = 5_000,
        )`
        `fun Train.isExpensive(): Boolean {
        println("Train의 확장함수")
        return this.price >= 10_000
        }`
    - Lambda Function
      - `val filterFruits = filterFruits(fruits) { it.name == "사과" }
        println(filterFruits.stream().map { it.name }.toList())`
- 구조분해(ComponentN)
  - // 구조분해: 복합적인 값을 분해하여 여러 변수를 한 번에 초기화 하는 것
  - `val person = Person("이수호", 25)
    // name과 age를 한번에 초기화
    val (name, age) = person`
  
  - // 위를 풀어쓴다면,
  - `val nameC = person.component1()
    val ageC = person.component2()`
  - // 구조분해 문법을 쓴다는 것은 componentN 메소드를 사용한다는 것이다.
- TypeAlias And AsImport
  - typealias
    - typealias를 사용하면 함수의 파라미터로 함수를 전달할 때 함수의 파라미터의 타입을 간결하게 표현할 수 있다.
      - `typealias MyInt = Int`
      - `typealias PersonName = String`
      - `typealias PersonAge = Int`
      - `typealias PersonInfo = Pair<PersonName, PersonAge>`
      - `typealias PersonInfoList = List<PersonInfo>`
      - `typealias PersonInfoList = List<Pair<PersonName, PersonAge>>`
  - as import
    - 같은 이름의 함수를 사용할 때는 as import를 통해서 구분할 수 있다.
      - `import com.example.kotlinstudy.KotlinCat as Cat`
      - `import com.example.kotlinstudy.KotlinCat`
      - `val cat = Cat("cat")`
      - `val cat = KotlinCat("cat")`
- takeIf
  - takeIf는 조건식을 만족하면 객체를 반환하고, 만족하지 않으면 null을 반환한다.
    - `val str: String? = "Hello Kotlin"
      val result = str?.takeIf { it.startsWith("H") }`
- takeUnless
  - takeUnless는 조건식을 만족하지 않으면 객체를 반환하고, 만족하면 null을 반환한다.
    - `val str: String? = "Hello Kotlin"
      val result = str?.takeUnless { it.startsWith("H") }`
- Scope Function
  - 일시적인 영역을 형성하는 함수
    - let
    - let은 함수의 파라미터로 전달된 람다식을 실행한다. 이후 람다식의 결과값을 반환한다.
    - let 내부에는 it 키워드를 사용하여 접근할 수 있다.
      - `val str: String? = "Hello Kotlin"
        val result = str?.let { it.length }`
    - run
      - run은 함수의 파라미터로 전달된 람다식을 실행한다. 이후 람다식의 결과값을 반환한다.
      - run은 let과 다르게 람다식 내부에서 this를 사용할 수 있다.
        - `val str: String? = "Hello Kotlin"
            val result = str?.run { this.length }`
    - also
      - also는 함수의 파라미터로 전달된 람다식을 실행한다. 이후 객체 자신을 반환한다.
      - also 내부에는 it 키워드를 사용하여 접근할 수 있다.
        - `val str: String? = "Hello Kotlin"
            val result = str?.also { KotlinCat(it) }`
    - apply
      - apply는 함수의 파라미터로 전달된 람다식을 실행한다. 이후 객체 자신을 반환한다.
      - apply는 also와 다르게 람다식 내부에서 this를 사용할 수 있다.
        - `val str: String? = "Hello Kotlin"
            val result = str?.apply { KotlinCat(this) }`
    - with
    - 확장 함수가 아니다.
      - `val value5 = with(person) {
        this.age
        }`