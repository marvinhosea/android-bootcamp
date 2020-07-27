package pro.marvinhosea.movielist.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import pro.marvinhosea.movielist.data.models.*
import pro.marvinhosea.movielist.repository.MoviesRepository

class SyncWorker(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {
    private val moviesRepository by lazy { MoviesRepository(applicationContext) }

    override suspend fun doWork(): Result {
        val movieTypes = arrayListOf(UPCOMING_CATEGORY, POPULAR_CATEGORY, NOW_PLAYING_CATEGORY, TOP_RATED_CATEGORY)
        movieTypes.forEach {
            moviesRepository.getMoviesFromApi(it)
        }
        moviesRepository.sendNotification()
        return Result.success()
    }
}