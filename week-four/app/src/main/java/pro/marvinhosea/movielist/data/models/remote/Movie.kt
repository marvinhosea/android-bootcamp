package pro.marvinhosea.movielist.data.models.remote

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Int,
    val vote_count: Int
)