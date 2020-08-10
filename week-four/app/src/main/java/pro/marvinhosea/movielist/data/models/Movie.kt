package pro.marvinhosea.movielist.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

const val UPCOMING_CATEGORY = "Upcoming Movies"
const val TOP_RATED_CATEGORY = "Top Rated Movies"
const val POPULAR_CATEGORY = "Popular Movies"
const val NOW_PLAYING_CATEGORY = "Now Playing Movies"

@Entity(tableName = "movies")
@Parcelize
data class Movie(
    @PrimaryKey val id: Int,
    val name: String,
    val summary: String,
    val rate: Double,
    var posterLink: String? = null,
    val category: String,
    val releaseDate: String,
    var inWatchList: Boolean = false,
    var userName: String
) : Parcelable