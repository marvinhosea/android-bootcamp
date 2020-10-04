package pro.marvinhosea.kardi

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import pro.marvinhosea.kardi.ui.game.GameViewModel
import pro.marvinhosea.kardi.ui.home.HomeViewModel

class MainActivity : AppCompatActivity() {
    private val homeViewModel by inject<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_game_dashboard, R.id.navigation_account))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        setUp()
    }

    private fun setUp() {
        lifecycleScope.launch {
            val cards = homeViewModel.getAllCards()
            if (cards.size < 10){
                homeViewModel.insertCards()
            }
        }
    }
}