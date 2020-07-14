package pro.marvinhosea.movielist.ui.movies.show

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.repository.MoviesRepository

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository by lazy {
        MoviesRepository(application)
    }

    /**
     * Retrieve movie by movie ID
     */
    suspend fun getMovie(movieId: Int): Movie {
        return movieRepository.getMovie(movieId)
    }

    suspend fun addToWatchList(movie: Movie) {
        movieRepository.addMovieToWatchList(movie)
    }
}