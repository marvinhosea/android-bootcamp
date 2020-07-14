package pro.marvinhosea.movielist.networking

import pro.marvinhosea.movielist.data.models.response.GetMoviesResponse
import retrofit2.http.GET
import retrofit2.http.*

interface RemoteServiceApi {
    @GET("movie/popular")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String): GetMoviesResponse
}