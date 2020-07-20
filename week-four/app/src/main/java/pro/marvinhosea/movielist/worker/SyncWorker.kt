package pro.marvinhosea.movielist.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.adapters.MOVIE_IMG_BASE_PATH
import pro.marvinhosea.movielist.data.models.*
import pro.marvinhosea.movielist.networking.RemoteApi
import pro.marvinhosea.movielist.networking.buildApiService
import pro.marvinhosea.movielist.repository.MoviesRepository
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

class SyncWorker(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {
    private val apiService by lazy { buildApiService() }
    private val remoteApi by lazy { RemoteApi(apiService) }

    override suspend fun doWork(): Result {
        val movieTypes = arrayListOf(UPCOMING_CATEGORY, POPULAR_CATEGORY, NOW_PLAYING_CATEGORY, TOP_RATED_CATEGORY)
        movieTypes.forEach {
            getMovies(it)
        }
        sendNotification()
        return Result.success()
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
            val movies = formatResponseMovies(results.data, category)
            MoviesRepository(applicationContext).storeMovies(movies)
        } else {
            Log.d("Error1", "An error occurred")
        }
    }

    private fun formatResponseMovies(moviesResponse: List<pro.marvinhosea.movielist.data.models.response.Result>, category: String): List<Movie> {
        val movies = mutableListOf<Movie>()
        val userName = UserSharedPrefRepository.getUserName()

        moviesResponse.forEach {
            movies.add(
                Movie(
                    it.id,
                    it.title,
                    it.overview,
                    it.vote_average,
                    it.poster_path?.let { it1 -> downloadImage(it1.replace("/", "")) },
                    category,
                    it.release_date,
                    false,
                    userName
                )
            )
        }
        return movies
    }

    private fun downloadImage(posterUrl: String): String {
        val imageUrl = URL(MOVIE_IMG_BASE_PATH + posterUrl)
        Log.d("imagePath", posterUrl)
        val connection = imageUrl.openConnection() as HttpURLConnection
        connection.doInput = true
        connection.connect()

        val inputStream = connection.inputStream
        val file = File(applicationContext.externalMediaDirs.first(), posterUrl)

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

        return file.absolutePath
    }

    private fun sendNotification() {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
        val notification: NotificationCompat.Builder = NotificationCompat.Builder(
            applicationContext,
            "default"
        )
            .setContentTitle("Movie Sync completed")
            .setContentText("Up to date all movies synced successfully")
            .setSmallIcon(R.mipmap.ic_launcher)
        notificationManager.notify(1, notification.build())
    }
}