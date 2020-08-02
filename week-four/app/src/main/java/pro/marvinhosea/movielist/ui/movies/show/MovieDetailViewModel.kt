package pro.marvinhosea.movielist.ui.movies.show

import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject
import pro.marvinhosea.movielist.App
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.networking.RemoteApi
import pro.marvinhosea.movielist.repository.MoviesRepository

class MovieDetailViewModel : ViewModel(), KoinComponent {
    private val movieRepository by inject<MoviesRepository>()

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