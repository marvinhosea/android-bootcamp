package pro.marvinhosea.movielist.repository

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LiveData
import org.koin.core.KoinComponent
import pro.marvinhosea.movielist.App
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.data.db.dao.MovieDao
import pro.marvinhosea.movielist.data.db.MovieDatabase
import pro.marvinhosea.movielist.data.models.Success
import pro.marvinhosea.movielist.networking.RemoteApi

open class MoviesRepository(private val remoteApi: RemoteApi, private val movieDao: MovieDao) : KoinComponent {
    /**
     * Store list of movies
     */
    private suspend fun storeMovies(movies: List<Movie>) {
        movieDao.storeMovies(movies)
    }

    /**
     * Fetch all movies
     */
    fun getAllMovies(): LiveData<List<Movie>> {
        return movieDao.fetchMovies()
    }

    /**
     * Fetch by categories
     */
    fun getMoviesByCategory(category: String): LiveData<List<Movie>> {
        return movieDao.fetchByCategory(category)
    }

    /**
     * Fetch single movie
     */
    suspend fun getMovie(movieId: Int): Movie {
        return movieDao.fetchMovieById(movieId)
    }

    suspend fun addMovieToWatchList(movie: Movie) {
        movieDao.updateMovie(movie)
    }

    suspend fun getMyMoviesWatchlist(userName: String, inWatchlist: Boolean = true): List<Movie> {
        return movieDao.fetchMyWatchlistMovies(userName, inWatchlist)
    }

    suspend fun getMoviesFromApi(category: String) {
        val results = when (category) {
            "Upcoming Movies" -> remoteApi.getUpcomingMovies()
            "Top Rated Movies" -> remoteApi.getTopRatedMovies()
            "Now Playing Movies" -> remoteApi.getNowPlayingMovies()
            else -> {
                remoteApi.getPopularMovies()
            }
        }

        if (results is Success) {
            val movies = formatResponseMovies(results.data, category)
            storeMovies(movies)
        } else {
            Log.d("Error1", "An error occurred")
        }
    }

    private fun formatResponseMovies(moviesResponse: List<pro.marvinhosea.movielist.data.models.response.Result>, category: String): List<Movie> {
        val movies = mutableListOf<Movie>()
        val userName = UserSharedPrefRepository.getUserName()

        moviesResponse.forEach {
            movies.add(
                Movie(
                    it.id,
                    it.title,
                    it.overview,
                    it.vote_average,
                    it.poster_path,
                    category,
                    it.release_date,
                    false,
                    userName
                )
            )
        }
        return movies
    }

}