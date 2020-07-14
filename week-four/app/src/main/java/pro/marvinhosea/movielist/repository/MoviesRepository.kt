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
    suspend fun getAllMovies(): List<Movie> {
        return movieDao.fetchMovies()
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
}