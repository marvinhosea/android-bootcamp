package pro.marvinhosea.kardi.db.models

data class GameResult(
    val gameId: String,
    val winner: String,
    val points: Int
)