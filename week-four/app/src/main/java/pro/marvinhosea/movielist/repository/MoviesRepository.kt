package pro.marvinhosea.movielist.repository

import android.content.Context
import androidx.lifecycle.LiveData
import pro.marvinhosea.movielist.models.Movie
import pro.marvinhosea.movielist.models.MovieDao
import pro.marvinhosea.movielist.models.MovieDatabase

class MoviesRepository(context: Context) {
    private val movieDao: MovieDao by lazy { MovieDatabase.getDatabase(context)!!.movieDao() }

    suspend fun saveMovie(movie: Movie) {
        movieDao.insert(movie)
    }

    fun getAllMovies(): LiveData<List<Movie>> = movieDao.getAllMovies()
}