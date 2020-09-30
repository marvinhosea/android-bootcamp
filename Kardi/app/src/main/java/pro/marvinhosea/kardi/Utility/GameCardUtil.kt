package pro.marvinhosea.kardi.Utility

import pro.marvinhosea.kardi.db.models.Card

suspend fun allCards(): MutableList<Card>{
    var cards = mutableListOf<Card>()
    cards.add(
        Card(
        1,
        "heart",
        "red",
        "3",
        "23",
        30,
        "six_of_flower"
        ))
    return cards
}