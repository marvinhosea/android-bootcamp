package pro.marvinhosea.movielist.ui.movies.show

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.R.drawable.baseline_favorite_border_white_18dp
import pro.marvinhosea.movielist.adapters.MOVIE_IMG_BASE_PATH
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.utils.toast

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var movieId: String
    private lateinit var movie: Movie
    private lateinit var frontAnim: AnimatorSet
    private lateinit var backAnim: AnimatorSet
    private var isPoster = true
    private val movieDetailViewModel by inject<MovieDetailViewModel>()
    private var drawable = baseline_favorite_border_white_18dp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        movieId = intent.getStringExtra(getString(R.string.MOVIE_INTENT))
        lifecycleScope.launch {
            movie = movieDetailViewModel.getMovie(movieId.toInt())
            if (movie.inWatchList) {
                drawable = R.drawable.baseline_remove_circle_outline_white_18dp
            }
            displayMovie()
            title = movie.name
        }

        val scale: Float = applicationContext.resources.displayMetrics.density
        imageCardView.cameraDistance = 8000 * scale
        movieDescription.cameraDistance = 8000 * scale

        frontAnim = AnimatorInflater.loadAnimator(this, R.animator.front_animator) as AnimatorSet
        backAnim = AnimatorInflater.loadAnimator(this, R.animator.back_animator) as AnimatorSet

        flipBtn.setOnClickListener {
            isPoster = if (isPoster) {
                frontAnim.setTarget(imageCardView)
                backAnim.setTarget(movieDescription)
                frontAnim.start()
                backAnim.start()
                flipBtn.setText(getString(R.string.view_movie_poster))
                false
            } else {
                frontAnim.setTarget(movieDescription)
                backAnim.setTarget(imageCardView)
                backAnim.start()
                frontAnim.start()
                flipBtn.setText(getString(R.string.view_detail))
                true
            }
        }
    }

    private fun displayMovie() {
        Glide.with(this)
            .load(MOVIE_IMG_BASE_PATH + movie.posterLink)
            .placeholder(R.drawable.grinch)
            .error(R.drawable.grinch)
            .fallback(R.drawable.grinch)
            .into(detail_image_view)
        detail_movie_name.text = movie.name
        detail_movie_genre.text = getString(R.string.movie_rating, movie.rate.toString())
        detail_release_date.text = getString(R.string.movie_release_date_text, movie.releaseDate)
        detail_movie_summary.text = movie.summary
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_detail, menu)
        menu.findItem(R.id.action_add_to_watch_list).setIcon(drawable)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add_to_watch_list -> {
                item.setIcon(addToWatchList())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addToWatchList(): Int {
        lifecycleScope.launch {
            movie.inWatchList = !movie.inWatchList
            movieDetailViewModel.addToWatchList(movie)
        }

        if (!movie.inWatchList) {
            toast("Movie added to your watch list")
            return R.drawable.baseline_remove_circle_outline_white_18dp
        }
        toast("Movie removed from your watch list")
        return baseline_favorite_border_white_18dp
    }
}