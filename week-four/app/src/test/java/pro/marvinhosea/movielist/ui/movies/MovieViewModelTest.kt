package pro.marvinhosea.movielist.ui.movies

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.data.models.POPULAR_CATEGORY

class MovieViewModelTest {
    private val modeMovieViewModel by lazy { MovieViewModel() }

    @Test
    fun testAllMoviesHasObservers() {
        GlobalScope.launch {
            val movies = modeMovieViewModel.getAllMovies()
            assertTrue(movies.hasObservers())
        }
    }

    @Test
    fun testReturnListOfMovies(){
        GlobalScope.launch {
            val movies = modeMovieViewModel.getAllMovies()
            assertEquals(listOf<Movie>(), movies)
        }
    }

    @Test
    fun testGetMoviesByCategory() {
        GlobalScope.launch {
            val movies = modeMovieViewModel.getMoviesByCategory(POPULAR_CATEGORY)
            assertEquals(listOf<Movie>(), movies)
        }
    }
}