package pro.marvinhosea.movielist.ui.movies.show

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.coroutines.*
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.data.models.Movie

class MovieDetailActivity : AppCompatActivity() {

    private val scope = MainScope()
    private lateinit var movieId: String
    private lateinit var movie: Movie
    private lateinit var movieDetailViewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        //Receive the movie intent and assign it to movie as @pro.marvinhosea.movielist.data.models.remote.Movie
        movieId = intent.getStringExtra(getString(R.string.MOVIE_INTENT))
        movieDetailViewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)

        scope.launch {
            movie = movieDetailViewModel.getMovie(movieId.toInt())
            displayMovie()
            title = movie.name
        }

    }

    private fun displayMovie() {

        detail_movie_name.text = movie.name
        detail_movie_genre.text = getString(R.string.movie_rating, movie.rate.toString())
        detail_release_date.text = getString(R.string.movie_release_date_text, movie.releaseDate)
        detail_movie_summary.text = movie.summary
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add_to_watch_list -> addToWatchList()
        }
        return super.onOptionsItemSelected(item)
    }


    /**
     * Delete a movie
     */
    private fun addToWatchList() {
        scope.launch {
            movie.inWatchList = true
            movieDetailViewModel.addToWatchList(movie)
        }
        this.finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

}