package pro.marvinhosea.kardi.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_players")
data class GamePlayer(
    @PrimaryKey(autoGenerate = true)
    val index: Int?,
    @ColumnInfo(name = "game_id")
    val gameId: Int,
    @ColumnInfo(name = "player_id")
    val playerId: Int
) {
}