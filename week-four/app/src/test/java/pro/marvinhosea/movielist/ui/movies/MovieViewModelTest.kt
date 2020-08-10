package pro.marvinhosea.movielist.ui.movies

import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Test

import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.get
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import pro.marvinhosea.movielist.di.networkModule
import pro.marvinhosea.movielist.di.repositoryModule
import pro.marvinhosea.movielist.di.viewModelModule
import pro.marvinhosea.movielist.repository.MoviesRepository

class MovieViewModelTest : KoinTest {
    private val moviesRepository: MoviesRepository = mock()
    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        startKoin {
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
        MockitoAnnotations.initMocks(this)
        movieViewModel = MovieViewModel(get())
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `Get all movies`() {
        movieViewModel.getAllMovies()
        verify(moviesRepository).getAllMovies()
        stopKoin()
    }


}