data class Card(
        val pip: String,
        val suit: Char
)


fun main() {
    val card = Card("10", 'C')
    println(card)
}