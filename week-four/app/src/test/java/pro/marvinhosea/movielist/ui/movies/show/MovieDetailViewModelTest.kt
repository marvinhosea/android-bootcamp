package pro.marvinhosea.movielist.ui.movies.show

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.junit.Assert.*
import org.junit.Test
import pro.marvinhosea.movielist.data.models.Movie

class MovieDetailViewModelTest {
    private val movieDetailViewModel by lazy { MovieDetailViewModel() }
    var movie = Movie(
        3452,
        "Test Movie",
        "This is a test movie",
        7.0,
        null,
        "Action",
        "3.04.2020",
        false,
        "marvin"
    )

    @Test
    fun testCanAddMovieWithNoPosterLinkToWatchlist() {
        movie.posterLink = null

        GlobalScope.launch {
            val isMovieEmpty = movieDetailViewModel.addToWatchList(movie)
            assertTrue(isMovieEmpty)
        }
    }
}