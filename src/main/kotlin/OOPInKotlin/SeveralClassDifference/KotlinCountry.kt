package org.example.OOPInKotlin.SeveralClassDifference



// when 케이스
fun handleCountry(country: KotlinCountry) {
    // when은 enum class에서 자주 사용된다.
    when (country) {
        KotlinCountry.KOREA -> TODO()
        KotlinCountry.AMERICA -> TODO()
    }
}

enum class KotlinCountry(
    private val code: String,
) {
    KOREA("KO"),
    AMERICA("US");
}