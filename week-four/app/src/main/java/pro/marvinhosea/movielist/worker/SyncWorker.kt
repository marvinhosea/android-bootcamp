package pro.marvinhosea.movielist.worker

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json.Default.context
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.data.models.Success
import pro.marvinhosea.movielist.data.models.response.Result
import pro.marvinhosea.movielist.networking.RemoteApi
import pro.marvinhosea.movielist.networking.buildApiService
import pro.marvinhosea.movielist.repository.MoviesRepository
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository
import pro.marvinhosea.movielist.ui.login.UserLoginActivity
import pro.marvinhosea.movielist.utils.toast
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL
import android.widget.Toast.makeText as makeText1

class SyncWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    private val apiService by lazy { buildApiService() }
    private val remoteApi by lazy { RemoteApi(apiService) }
    override fun doWork(): Result {
        val imagesDownloadPath = "https://www.wallpaperup.com/uploads/wallpapers/2013/03/21/55924/3b61c716155c6fa88f321da6d4655767.jpg"
        val imageUrl = URL(imagesDownloadPath)
        Log.d("imagePath", "running")
        val connection = imageUrl.openConnection() as HttpURLConnection
        connection.doInput = true
        connection.connect()

        val imagePath = "${System.currentTimeMillis()}.jpg"
        val inputStream = connection.inputStream
        val file = File(applicationContext.externalMediaDirs.first(), imagePath)

        val outputStream = FileOutputStream(file)
        outputStream.use { output ->
            val buffer = ByteArray(4 * 1024)
            var byteCount = inputStream.read(buffer)

            while (byteCount > 0) {
                output.write(buffer, 0, byteCount)
                byteCount = inputStream.read(buffer)
            }

            output.flush()
        }

        val movies = GlobalScope.launch {
            getMovies("Upcoming Movies")
        }
        val output = workDataOf("image_path" to file.absolutePath)
        Log.d("imagePath", output.toString())
        return Result.success(output)
    }

    private suspend fun getMovies(category: String) {
        val results = when (category) {
            "Upcoming Movies" -> remoteApi.getUpcomingMovies()
            "Top Rated Movies" -> remoteApi.getTopRatedMovies()
            "Now Playing Movies" -> remoteApi.getNowPlayingMovies()
            else -> {
                remoteApi.getPopularMovies()
            }
        }

        if (results is Success) {
            val movies = formatResponseMovies(results.data)
            MoviesRepository(applicationContext).storeMovies(movies)
        } else {
            Log.d("Error1", "testing ${results.toString()}")
        }
    }

    private fun formatResponseMovies(moviesResponse: List<pro.marvinhosea.movielist.data.models.response.Result>): List<Movie> {
        val movies = mutableListOf<Movie>()
        val userName = UserSharedPrefRepository.getUserName()

        moviesResponse.forEach {
            movies.add(
                Movie(
                    it.id,
                    it.title,
                    it.overview,
                    it.vote_average,
                    it.poster_path,
                    it.release_date,
                    false,
                    userName
                )
            )
        }
        return movies
    }
}