package pro.marvinhosea.movielist.ui.movies.show

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.data.models.Movie

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieId: String
    private lateinit var movie: Movie
    private lateinit var movieDetailViewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        //Receive the movie intent and assign it to movie as @Movie
        movieId = intent.getStringExtra(getString(R.string.MOVIE_INTENT))
        movieDetailViewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)

        movieDetailViewModel.getMovie(movieId).observe(this, Observer {
            it?.let {
                movie = it
                displayMovie()
                title = movie.name
            }
        })
    }

    private fun displayMovie() {
        Picasso.get()
            .load(movie.posterLink)
            .error(R.drawable.grinch)
            .placeholder(R.drawable.grinch)
            .into(detail_image_view)

        detail_movie_name.text = movie.name
        detail_movie_genre.text = getString(R.string.movie_genre, movie.genre)
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
            R.id.action_delete -> deleteMovie()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Delete a movie
     */
    private fun deleteMovie() {
        movieDetailViewModel.deleteMovie(movie)
        this.finish()
    }
}