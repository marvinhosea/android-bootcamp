package pro.marvinhosea.movielist.data.models.response

import kotlinx.serialization.Serializable
import pro.marvinhosea.movielist.data.models.remote.Movie

@Serializable
data class GetMoviesResponse(val movies: List<Movie> = listOf())