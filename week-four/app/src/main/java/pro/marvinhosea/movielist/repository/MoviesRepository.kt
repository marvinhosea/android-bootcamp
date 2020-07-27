package pro.marvinhosea.movielist.repository

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LiveData
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.data.db.dao.MovieDao
import pro.marvinhosea.movielist.data.db.MovieDatabase
import pro.marvinhosea.movielist.data.models.Success
import pro.marvinhosea.movielist.networking.RemoteApi
import pro.marvinhosea.movielist.networking.buildApiService

class MoviesRepository(private val context: Context) {
    private val movieDao: MovieDao by lazy { MovieDatabase.getDatabase(context).movieDao() }
    private val apiService by lazy { buildApiService() }
    private val remoteApi by lazy { RemoteApi(apiService) }

    /**
     * Store list of movies
     */
    suspend fun storeMovies(movies: List<Movie>) {
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

    fun sendNotification() {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
        val notification: NotificationCompat.Builder = NotificationCompat.Builder(
            context,
            "default"
        )
            .setContentTitle("Movie Sync completed")
            .setContentText("Up to date all movies synced successfully")
            .setSmallIcon(R.mipmap.ic_launcher)
        notificationManager.notify(1, notification.build())
    }
}