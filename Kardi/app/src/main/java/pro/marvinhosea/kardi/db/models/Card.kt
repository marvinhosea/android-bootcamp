package pro.marvinhosea.kardi.db.models

data class Card(
    val name: String,
    val color: String,
    val suit: String,
    val pip: String,
    val value: Int,
    val poster: String
) {
}