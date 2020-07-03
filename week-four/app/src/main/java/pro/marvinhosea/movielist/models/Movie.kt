package pro.marvinhosea.movielist.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "movies_table")
@Parcelize
data class Movie(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val summary: String,
    val genre: String,
    val posterId: Int,
    val releaseDate: String
) : Parcelable