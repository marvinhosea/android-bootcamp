package pro.marvinhosea.movielist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_detail.*
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.data.models.Movie

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        //Receive the movie intent and assign it to movie as @Movie
        movie = intent.getParcelableExtra(getString(R.string.MOVIE_INTENT)) as Movie

        //Set the title of the new activity
        title = movie.name

        //Set values to the view
        detail_image_view.setImageResource(movie.posterId)
        detail_movie_name.text = getString(R.string.movie_name_text, movie.name)
        detail_movie_genre.text = getString(R.string.movie_genre, movie.genre)
        detail_release_date.text = getString(R.string.movie_release_date_text, movie.releaseDate)
        detail_movie_summary.text = movie.summary
    }
}