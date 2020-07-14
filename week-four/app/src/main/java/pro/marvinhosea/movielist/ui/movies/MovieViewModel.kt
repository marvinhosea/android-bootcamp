package pro.marvinhosea.movielist.ui.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.repository.MoviesRepository

open class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository = MoviesRepository(application.applicationContext)

    suspend fun getAllMovies(): List<Movie> {
        val movies = movieRepository.getAllMovies()
        if (movies.isNullOrEmpty()){
            return emptyList<Movie>()
        }

        return movies
    }

    suspend fun saveMovies(moviesToSaveToRoom: List<Movie>) {
        movieRepository.storeMovies(moviesToSaveToRoom)
    }
}