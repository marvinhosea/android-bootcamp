package pro.marvinhosea.kardi.Utility

import pro.marvinhosea.kardi.R
import pro.marvinhosea.kardi.db.models.Card
import pro.marvinhosea.kardi.db.models.Suit

val cardNumbers = arrayOf("two","three","four","five","six","seven","eight","nine","ten", "ace")
val cardSuits = arrayOf(
    Suit("diamonds", "red"),
    Suit("hearts", "red"),
    Suit("clubs", "black"),
    Suit("spades", "black")
)
val mapOfCards = mapOf(
    "ace_of_clubs" to  R.drawable.ace_of_clubs,
    "ace_of_diamonds" to  R.drawable.ace_of_diamonds,
    "ace_of_hearts" to  R.drawable.ace_of_hearts,
    "ace_of_spades" to  R.drawable.ace_of_spades,
    "eight_of_clubs" to  R.drawable.eight_of_clubs,
    "eight_of_clubs" to R.drawable.eight_of_clubs,
    "eight_of_diamonds" to R.drawable.eight_of_diamonds,
    "eight_of_hearts" to R.drawable.eight_of_hearts,
    "eight_of_spades" to R.drawable.eight_of_spades,
    "five_of_clubs" to R.drawable.five_of_clubs,
    "five_of_diamonds" to R.drawable.five_of_diamonds,
    "five_of_hearts" to R.drawable.five_of_hearts,
    "five_of_spades" to R.drawable.five_of_spades,
    "four_of_clubs" to R.drawable.four_of_clubs,
    "four_of_diamonds" to R.drawable.four_of_diamonds,
    "four_of_hearts" to R.drawable.four_of_hearts,
    "four_of_spades" to R.drawable.four_of_spades,
    "nine_of_clubs" to R.drawable.nine_of_clubs,
    "nine_of_diamonds" to R.drawable.nine_of_diamonds,
    "nine_of_hearts" to R.drawable.nine_of_hearts,
    "nine_of_spades" to R.drawable.nine_of_spades,
    "seven_of_clubs" to R.drawable.seven_of_clubs,
    "seven_of_hearts" to R.drawable.seven_of_hearts,
    "seven_of_diamonds" to R.drawable.seven_of_diamonds,
    "seven_of_spades" to R.drawable.seven_of_spades,
    "six_of_clubs" to R.drawable.six_of_clubs,
    "six_of_diamonds" to R.drawable.six_of_diamonds,
    "six_of_hearts" to R.drawable.six_of_hearts,
    "six_of_spades" to R.drawable.six_of_spades,
    "ten_of_clubs" to R.drawable.ten_of_clubs,
    "ten_of_diamonds" to R.drawable.ten_of_diamonds,
    "ten_of_hearts" to R.drawable.ten_of_hearts,
    "ten_of_spades" to R.drawable.ten_of_spades,
    "three_of_clubs" to R.drawable.three_of_clubs,
    "three_of_diamonds" to R.drawable.three_of_diamonds,
    "three_of_hearts" to R.drawable.three_of_hearts,
    "three_of_spades" to R.drawable.three_of_spades,
    "two_of_clubs" to R.drawable.two_of_clubs,
    "two_of_diamonds" to R.drawable.two_of_diamonds,
    "two_of_hearts" to R.drawable.two_of_hearts,
    "two_of_spades" to R.drawable.two_of_spades
)

suspend fun allCards(): MutableList<Card>{
    return generateCards()
}

private fun generateCards(): MutableList<Card> {
    val cards = mutableListOf<Card>()

    for (number in cardNumbers){
        for (suit in cardSuits){
            cards.add(
                Card(
                    null,
                    suit.suit,
                    suit.color,
                    suit.suit,
                    suit.suit,
                    when(number){
                        "two","three","four","five","six","seven","eight","nine","ten" -> 10
                        else -> 11
                    },
                    mapOfCards[number + "_of_" + suit.suit]
                )
            )
        }
    }

    return cards
}