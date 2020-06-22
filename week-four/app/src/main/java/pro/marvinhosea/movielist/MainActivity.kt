package pro.marvinhosea.movielist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import pro.marvinhosea.movielist.activities.MovieDetailActivity
import pro.marvinhosea.movielist.adapters.MovieAdapter
import pro.marvinhosea.movielist.models.Movie

class MainActivity : AppCompatActivity(), MovieAdapter.MovieListClickListener {

    companion object {

        val INTENT_MOVIE_KEY = "movie_detail"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        movieRecyclerView.adapter = MovieAdapter(this, this )

//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }

    private fun showMovie(movie: Movie){
        val movieIntent = Intent(this, MovieDetailActivity::class.java)
        movieIntent.putExtra(INTENT_MOVIE_KEY, movie)
        startActivity(movieIntent)
    }

    override fun movieClicked(movie: Movie) {
        showMovie(movie)
    }
}