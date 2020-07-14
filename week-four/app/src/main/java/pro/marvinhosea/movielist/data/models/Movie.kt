package pro.marvinhosea.movielist.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movies")
@Parcelize
data class Movie(
    @PrimaryKey val id: Int,
    val name: String,
    val summary: String,
    val rate: Double,
    val posterLink: String,
    val releaseDate: String,
    var inWatchList: Boolean = false
) : Parcelable