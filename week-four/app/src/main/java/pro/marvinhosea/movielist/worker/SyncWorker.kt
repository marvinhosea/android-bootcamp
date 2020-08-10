package pro.marvinhosea.movielist.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import org.koin.core.KoinComponent
import org.koin.core.inject
import pro.marvinhosea.movielist.data.models.*
import pro.marvinhosea.movielist.repository.MoviesRepository
import pro.marvinhosea.movielist.utils.NotificationHelper

class SyncWorker(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters), KoinComponent {
    private val moviesRepository by inject<MoviesRepository>()
    private val notificationHelper by lazy { NotificationHelper() }

    override suspend fun doWork(): Result {
        val movieTypes = arrayListOf(UPCOMING_CATEGORY, POPULAR_CATEGORY, NOW_PLAYING_CATEGORY, TOP_RATED_CATEGORY)
        movieTypes.forEach {
            moviesRepository.getMoviesFromApi(it)
        }

        notificationHelper.sendNotification()
        return Result.success()
    }
}