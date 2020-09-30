package pro.marvinhosea.kardi.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hands")
data class PlayerHand(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "game_id")
    val gameId: Int,
    @ColumnInfo(name = "player_id")
    val playerId: Int,
    @ColumnInfo(name = "card_id")
    val cardId: Int
)