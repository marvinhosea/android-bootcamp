data class Card(
        val pip: String,
        val suit: Char
)

data class User(val name: String, val hand: Hand)
data class Hand(val cards: MutableList<Card>)

fun main() {
    fun createDeck(): MutableSet<Card>{
        val cardCollection = mutableSetOf<Card>()
        val suits = arrayOf('\u2663', '\u2660', '\u2666', '\u2665')

        val blackJackRange = 2..10

        for (pip in blackJackRange){
            for (suit in suits){
                cardCollection.add(Card(pip.toString(), suit))
            }
        }

        val faceCards = arrayOf('J', 'Q', 'K')

        for (faceCard in faceCards){
            for (suit in suits){
                cardCollection.add(Card(faceCard.toString(), suit))
            }
        }

        for (suit in suits){
            cardCollection.add(Card("A", suit))
        }

        return cardCollection
    }

    val cardDeck = createDeck()

    fun dealHand(cards: MutableList<Card>, allowCardAtHand: Int): MutableList<Card>{
        val cardsAtHand = mutableListOf<Card>()

        do {
            cardsAtHand.add(cards.random())
        } while (cardsAtHand.size < allowCardAtHand)

        return cardsAtHand
    }

    fun evaluateHand(userHand: Hand): Int{

        var sumCardValue = 0

        for (card in userHand.cards){

            val pip = if (card.pip == "J" || card.pip == "Q" || card.pip == "K"){
                10
            } else if (card.pip == "A"){
                11
            } else {
                card.pip.toInt()
            }

            sumCardValue += when (pip) {
                in 2..11 -> pip
                else -> 0
            }
        }
        return sumCardValue
    }

    fun printUserCards(cards: MutableList<Card>){
        println("""
            .------.
            |A     |
            |      .------.
            |    ${'\u2663'} |K     |
            |      |      |
            |      |   ${'\u2663'}  |
            `______|      |
                   |     K|
                   `______'""".trimIndent())
    }

    fun printResults(user: User, total: Int){
        val messageType = Pair("You Win, Congrats", "You Lose, sorry")

        println("You hand was")

        for (card in user.hand.cards){
            println(card.pip + card.suit)
        }

        println("For a total of:$total")

        val (win, lose) = messageType

        if (total <= 21){
            println(win)
        } else {
            println(lose)
        }
    }
    val userCardsAtHand = Hand(dealHand(cardDeck.toMutableList(), 3))

    val user = User("Marvin", userCardsAtHand)
    val total = evaluateHand(userCardsAtHand)

    printResults(user, total)
}