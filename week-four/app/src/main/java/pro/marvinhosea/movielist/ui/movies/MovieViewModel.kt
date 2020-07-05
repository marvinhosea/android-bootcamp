package pro.marvinhosea.movielist.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.repository.MoviesRepository

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository = MoviesRepository(application.applicationContext)
    val movies = movieRepository.getAllMovies()

    fun saveMovie(movie: Movie){
        viewModelScope.launch {
            movieRepository.saveMovie(movie)
        }
    }
}