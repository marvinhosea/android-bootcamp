package pro.marvinhosea.movielist.ui.movies

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.ui.login.UserLoginActivity
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository
import pro.marvinhosea.movielist.ui.movies.create.AddMovieActivity

class MainActivity : AppCompatActivity() {

    private var userSharedRepository = UserSharedPrefRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        userSharedRepository.init(this)
    }

    override fun onStart() {
        super.onStart()

        if (!userSharedRepository.isUserLoggedIn()) {
            val intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onResume() {
        super.onResume()

        if (!userSharedRepository.isUserLoggedIn()) {
            val intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_menu -> logOut()
            R.id.add_movie -> addMovie()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addMovie() {
        val intent = Intent(this, AddMovieActivity::class.java)
        startActivity(intent)
    }

    private fun logOut() {
        userSharedRepository.init(this)
        userSharedRepository.logoutUser()

        val intent = Intent(this, UserLoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}