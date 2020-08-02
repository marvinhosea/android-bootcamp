package pro.marvinhosea.movielist.networking

import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.qualifier.named
import pro.marvinhosea.movielist.data.models.Failure
import pro.marvinhosea.movielist.data.models.NetworkResult
import pro.marvinhosea.movielist.data.models.Success
import pro.marvinhosea.movielist.data.models.response.Result

class RemoteApi(private val apiServiceApi: RemoteServiceApi) : KoinComponent {
    suspend fun getUpcomingMovies(): NetworkResult<List<Result>> = try {
        val data = apiServiceApi.getUpcomingMovies(get(named("API_KEY")))
        Success(data.results)
    } catch (error: Throwable) {
        Failure(error)
    }

    suspend fun getPopularMovies(): NetworkResult<List<Result>> = try {
        val data = apiServiceApi.getPopularMovies(get(named("API_KEY")))

        Success(data.results)
    } catch (error: Throwable) {
        Failure(error)
    }

    suspend fun getTopRatedMovies(): NetworkResult<List<Result>> = try {
        val data = apiServiceApi.getTopRatedMovies(get(named("API_KEY")))

        Success(data.results)
    } catch (error: Throwable) {
        Failure(error)
    }

    suspend fun getNowPlayingMovies(): NetworkResult<List<Result>> = try {
        val data = apiServiceApi.getNowPlayingMovies(get(named("API_KEY")))

        Success(data.results)
    } catch (error: Throwable) {
        Failure(error)
    }
}