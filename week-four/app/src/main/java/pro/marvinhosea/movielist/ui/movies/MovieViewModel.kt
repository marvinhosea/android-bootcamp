package pro.marvinhosea.movielist.ui.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.repository.MoviesRepository
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository

open class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository = MoviesRepository(application.applicationContext)

    fun getAllMovies(): LiveData<List<Movie>> {
        return movieRepository.getAllMovies()
    }

    fun getMoviesByCategory(category: String): LiveData<List<Movie>> {
        return movieRepository.getMoviesByCategory(category)
    }

    suspend fun saveMovies(moviesToSaveToRoom: List<Movie>) {
        movieRepository.storeMovies(moviesToSaveToRoom)
    }

    suspend fun myWatchListMovies(): List<Movie> {
        val movies = movieRepository.getMyMoviesWatchlist(UserSharedPrefRepository.getUserName(), true)
        if (movies.isNullOrEmpty()) {
            return emptyList<Movie>()
        }

        return movies
    }
}