package pro.marvinhosea.movielist.ui.movies

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.networking.NetworkStatusChecker
import pro.marvinhosea.movielist.ui.login.UserLoginActivity
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository
import pro.marvinhosea.movielist.utils.toast
import pro.marvinhosea.movielist.worker.SyncWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private var userSharedRepository = UserSharedPrefRepository
    private val networkStatusChecker by lazy {
        NetworkStatusChecker(getSystemService(ConnectivityManager::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        userSharedRepository.init(this)
        if (userSharedRepository.isUserLoggedIn()) {
            syncMovies()
        }
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

    private fun syncMovies() {
        if (networkStatusChecker.hasInternetConnection()) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_ROAMING)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .setRequiresStorageNotLow(true)
                .build()

            val syncWorker = PeriodicWorkRequestBuilder<SyncWorker>(15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()

            val workManager = WorkManager.getInstance(this)
            workManager.enqueue(syncWorker)
        } else {
            toast("No internet connection")
        }
    }
}