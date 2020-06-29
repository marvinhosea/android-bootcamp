package pro.marvinhosea.movielist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_movie_detail.*
import pro.marvinhosea.movielist.MainActivity
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.fragments.MovieDetailFragment
import pro.marvinhosea.movielist.models.Movie

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movie: Movie
    private lateinit var movieDetailFragment: MovieDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
    }
}