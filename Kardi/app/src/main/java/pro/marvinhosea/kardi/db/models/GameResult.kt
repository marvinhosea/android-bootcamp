package pro.marvinhosea.kardi.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "results")
data class GameResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "game_id")
    val gameId: String,
    val winner: String,
    val points: Int
)