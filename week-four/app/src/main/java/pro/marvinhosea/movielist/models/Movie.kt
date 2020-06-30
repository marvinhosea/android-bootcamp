package pro.marvinhosea.movielist.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "movies_table")
data class Movie(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val summary: String,
    val genre: String,
    val posterId: Int,
    val releaseDate: String
)