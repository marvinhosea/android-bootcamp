package pro.marvinhosea.kardi.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tables")
data class Table(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "added_by")
    val addedBy: Int,
    @ColumnInfo(name = "game_id")
    val gameId: Int,
    @ColumnInfo(name = "card_id")
    val cardId: Int
)