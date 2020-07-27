package pro.marvinhosea.movielist.data.models.response

import kotlinx.serialization.Serializable

@Serializable
data class GetMoviesResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)