package pro.marvinhosea.movielist.repository

import android.content.Context
import androidx.lifecycle.LiveData
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.data.dao.MovieDao
import pro.marvinhosea.movielist.data.MovieDatabase

class MoviesRepository(context: Context) {
    private val movieDao: MovieDao by lazy { MovieDatabase.getDatabase(context).movieDao() }

    suspend fun storeMovie(movie: Movie) {
        movieDao.storeMovie(movie)
    }

    fun storeMovies(movies: List<Movie>) {
        movieDao.storeMovies(movies)
    }

    fun getAllMovies(): LiveData<List<Movie>> = movieDao.fetchMovies()

    fun getMovie(movieId: String): LiveData<Movie> {
        return movieDao.fetchMovieById(movieId)
    }

    suspend fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie)
    }
}