package pro.marvinhosea.movielist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pro.marvinhosea.movielist.fragments.MovieListFragment

class MainActivity : AppCompatActivity() {

    companion object {
        const val INTENT_MOVIE_KEY = "movie_detail"
    }

    private var movieListFragment = MovieListFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val intent = Intent(this, UserLoginActivity::class.java)
        startActivity(intent)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, movieListFragment)
            .commit()
    }
}