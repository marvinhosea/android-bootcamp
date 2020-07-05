package pro.marvinhosea.movielist.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "movies")
@Parcelize
data class Movie(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val summary: String,
    val genre: String,
    val posterLink: String,
    val releaseDate: String
) : Parcelable