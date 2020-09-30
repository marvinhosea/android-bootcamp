package pro.marvinhosea.kardi.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    var name: String,
    var initial: String
) {
}