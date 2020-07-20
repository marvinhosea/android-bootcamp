package pro.marvinhosea.movielist.repository

import android.content.Context
import androidx.lifecycle.LiveData
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.data.local.dao.MovieDao
import pro.marvinhosea.movielist.data.local.MovieDatabase

class MoviesRepository(context: Context) {
    private val movieDao: MovieDao by lazy { MovieDatabase.getDatabase(context).movieDao() }

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
}