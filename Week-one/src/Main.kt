data class Card(
        val pip: String,
        val suit: Char
)

fun main() {
    val card = Card("10", 'C')

    fun createDeck(): MutableSet<Card>{
        val cardCollection = mutableSetOf<Card>()
        val suits = arrayOf('\u2663', '\u2660', '\u2666', '\u2665')

        val blackJackRange = 2..10

        for (pip in blackJackRange){
            for (suit in suits){
                cardCollection.add(Card(pip.toString(), suit))
            }
        }

        return cardCollection
    }

}