package pro.marvinhosea.movielist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pro.marvinhosea.movielist.fragments.MovieListFragment
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository

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

        if (!userSharedRepository.isUserLoggedIn()){
            val intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_menu -> logOut()
            R.id.user_profile -> uploadProfilePhoto()
//            R.id.map_type_menu_item -> showMapTypeDialog()
//            R.id.clear_all_drops_menu_item -> showClearAllDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun uploadProfilePhoto(){
        Toast.makeText(this, "Working", Toast.LENGTH_LONG).show()
    }

    private fun logOut(){
        userSharedRepository.init(this)
        userSharedRepository.logoutUser()

        val intent = Intent(this, UserLoginActivity::class.java)
        startActivity(intent)
    }
}