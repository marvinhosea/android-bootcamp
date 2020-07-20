package pro.marvinhosea.movielist.ui.movies

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.work.*
import kotlinx.coroutines.launch
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.data.models.Success
import pro.marvinhosea.movielist.data.models.response.Result
import pro.marvinhosea.movielist.ui.login.UserLoginActivity
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository
import pro.marvinhosea.movielist.utils.toast
import pro.marvinhosea.movielist.worker.SyncWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private var userSharedRepository = UserSharedPrefRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        userSharedRepository.init(this)
        syncMovies()
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
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_ROAMING)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(true)
            .build()

        val downloadImageWorker = OneTimeWorkRequestBuilder<SyncWorker>()
//            .setInputData(workDataOf("movies" to imageUrl))
            .setConstraints(constraints)
            .build()

        val workManager = WorkManager.getInstance(this)
        workManager.enqueue(downloadImageWorker)

        workManager.getWorkInfoByIdLiveData(downloadImageWorker.id).observe(this, Observer { info ->
            if (info?.state?.isFinished == true) {
                toast("Image downloaded")
            }
        })
    }
}