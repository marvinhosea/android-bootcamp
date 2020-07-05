package pro.marvinhosea.movielist.ui.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.repository.MoviesRepository

open class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository = MoviesRepository(application.applicationContext)

    fun getAllMovies(): LiveData<List<Movie>> = movieRepository.getAllMovies()
}