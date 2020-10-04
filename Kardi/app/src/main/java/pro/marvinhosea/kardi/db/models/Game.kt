package pro.marvinhosea.kardi.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val code: String,
    val status: Boolean
)