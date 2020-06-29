package pro.marvinhosea.movielist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pro.marvinhosea.movielist.activities.MovieDetailActivity
import pro.marvinhosea.movielist.fragments.MovieListFragment
import pro.marvinhosea.movielist.models.Movie

class MainActivity : AppCompatActivity(), MovieListFragment.OnFragmentInteractionListener {

    companion object {
        const val INTENT_MOVIE_KEY = "movie_detail"
    }

    private var movieListFragment = MovieListFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, movieListFragment)
            .commit()
    }

    private fun showMovie(movie: Movie){
        val movieIntent = Intent(this, MovieDetailActivity::class.java)
        movieIntent.putExtra(INTENT_MOVIE_KEY, movie)
        startActivity(movieIntent)
    }

    override fun onMovieListClicked(movie: Movie) {
        showMovie(movie)
    }
}