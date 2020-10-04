package pro.marvinhosea.kardi.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val color: String,
    val suit: String,
    val pip: String,
    val value: Int,
    val poster: Int?
) {
}