package pro.marvinhosea.movielist.ui.movies.show

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.repository.MoviesRepository

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository by lazy {
        MoviesRepository(application)
    }

    /**
     * Retrieve movie by movie ID
     */
    fun getMovie(movieId: String): LiveData<Movie> {
        return movieRepository.getMovie(movieId)
    }

    /**
     * Delete movie
     */
    fun deleteMovie(movie: Movie) {
        viewModelScope.launch { movieRepository.deleteMovie(movie) }
    }
}