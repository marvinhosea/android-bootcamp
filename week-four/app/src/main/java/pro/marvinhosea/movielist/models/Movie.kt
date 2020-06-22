package pro.marvinhosea.movielist.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Movie data class
 */

@Parcelize
data class Movie(
    val id: Int,
    val name: String,
    val summary: String,
    val genre: String,
    val posterId: Int,
    val releaseDate: String
): Parcelable{

}