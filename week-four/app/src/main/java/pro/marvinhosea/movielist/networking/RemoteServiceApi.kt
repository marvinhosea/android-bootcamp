package pro.marvinhosea.movielist.networking

import pro.marvinhosea.movielist.data.models.response.GetMoviesResponse
import retrofit2.http.GET
import retrofit2.http.*

interface RemoteServiceApi {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String): GetMoviesResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): GetMoviesResponse

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("api_key") apiKey: String): GetMoviesResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apiKey: String): GetMoviesResponse
}