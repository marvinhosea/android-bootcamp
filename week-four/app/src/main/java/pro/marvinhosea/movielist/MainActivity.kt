package pro.marvinhosea.movielist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import pro.marvinhosea.movielist.viewmodels.MovieViewModel
import pro.marvinhosea.movielist.controllers.MovieController
import pro.marvinhosea.movielist.fragments.MovieListFragment
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository

class MainActivity : AppCompatActivity() {

    private var userSharedRepository = UserSharedPrefRepository
    private val movieViewModel by lazy {
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }

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
        }

    }

    override fun onResume() {
        super.onResume()

        if (!userSharedRepository.isUserLoggedIn()) {
            val intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
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
            R.id.duplicate_menu -> {
                movieViewModel.saveMovie(MovieController.getMovie())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun uploadProfilePhoto() {
        //TODO: implement image upload from memory
//        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
    }

    private fun logOut() {
        userSharedRepository.init(this)
        userSharedRepository.logoutUser()

        val intent = Intent(this, UserLoginActivity::class.java)
        startActivity(intent)
    }
}