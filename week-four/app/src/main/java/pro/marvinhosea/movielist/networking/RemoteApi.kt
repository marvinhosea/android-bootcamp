package pro.marvinhosea.movielist.networking

import pro.marvinhosea.movielist.data.models.Failure
import pro.marvinhosea.movielist.data.models.NetworkResult
import pro.marvinhosea.movielist.data.models.Success
import pro.marvinhosea.movielist.data.models.response.Result

const val BASE_URL = "https://api.themoviedb.org/3/"

class RemoteApi(private val apiServiceApi: RemoteServiceApi) {
    suspend fun getUpcomingMovies(): NetworkResult<List<Result>> = try {
        val data = apiServiceApi.getUpcomingMovies(API_KEY)

        Success(data.results)
    } catch (error: Throwable){
        Failure(error)
    }
}