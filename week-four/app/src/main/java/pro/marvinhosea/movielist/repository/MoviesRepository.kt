package pro.marvinhosea.movielist.repository

import android.content.Context
import androidx.lifecycle.LiveData
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.data.dao.MovieDao
import pro.marvinhosea.movielist.data.MovieDatabase

class MoviesRepository(context: Context) {
    private val movieDao: MovieDao by lazy { MovieDatabase.getDatabase(context).movieDao() }

    /**
     * Store single more
     */
    suspend fun storeMovie(movie: Movie) {
        movieDao.storeMovie(movie)
    }

    /**
     * Store list of movies
     */
    fun storeMovies(movies: List<Movie>) {
        movieDao.storeMovies(movies)
    }

    /**
     * Fetch all movies
     */
    fun getAllMovies(): LiveData<List<Movie>> = movieDao.fetchMovies()

    /**
     * Fetch single movie
     */
    fun getMovie(movieId: String): LiveData<Movie> {
        return movieDao.fetchMovieById(movieId)
    }

    /**
     * Delete movie
     */
    suspend fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie)
    }
}