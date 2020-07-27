package pro.marvinhosea.movielist.ui.movies.show

import androidx.lifecycle.ViewModel
import pro.marvinhosea.movielist.App
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.repository.MoviesRepository

class MovieDetailViewModel : ViewModel() {
    private val movieRepository by lazy {
        MoviesRepository(App.getAppContext())
    }

    /**
     * Retrieve movie by movie ID
     */
    suspend fun getMovie(movieId: Int): Movie {
        return movieRepository.getMovie(movieId)
    }

    suspend fun addToWatchList(movie: Movie): Boolean {
        movieRepository.addMovieToWatchList(movie)
        return true
    }
}