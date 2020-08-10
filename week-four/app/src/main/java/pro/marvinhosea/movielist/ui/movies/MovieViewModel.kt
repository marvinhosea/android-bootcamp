package pro.marvinhosea.movielist.ui.movies

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.repository.MoviesRepository
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository

open class MovieViewModel(private val movieRepository: MoviesRepository, private var userSharedRepository: UserSharedPrefRepository) : ViewModel() {

    fun getAllMovies(): LiveData<List<Movie>> {
        return movieRepository.getAllMovies()
    }

    fun getMoviesByCategory(category: String): LiveData<List<Movie>> {
        return movieRepository.getMoviesByCategory(category)
    }

    suspend fun myWatchListMovies(): List<Movie> {
        val movies = movieRepository.getMyMoviesWatchlist(UserSharedPrefRepository.getUserName(), true)
        if (movies.isNullOrEmpty()) {
            return emptyList()
        }
        return movies
    }

    fun logoutUser(context: Context) {
        userSharedRepository.init(context)
        userSharedRepository.logoutUser()
    }
}