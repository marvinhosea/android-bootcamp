package pro.marvinhosea.movielist.ui.movies.create

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.repository.MoviesRepository

class AddMovieViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository by lazy { MoviesRepository(application) }

    fun createMovie(movie: Movie) {
        viewModelScope.launch { movieRepository.storeMovie(movie) }
    }
}