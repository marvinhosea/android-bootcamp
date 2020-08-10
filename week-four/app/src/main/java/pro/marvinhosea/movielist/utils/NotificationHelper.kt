package pro.marvinhosea.movielist.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import pro.marvinhosea.movielist.App
import pro.marvinhosea.movielist.R

open class NotificationHelper {
    fun sendNotification() {
        val notificationManager =
            App.getAppContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
        val notification: NotificationCompat.Builder = NotificationCompat.Builder(
            App.getAppContext(),
            "default"
        )
            .setContentTitle("Movie Sync completed")
            .setContentText("Up to date all movies synced successfully")
            .setSmallIcon(R.mipmap.ic_launcher)
        notificationManager.notify(1, notification.build())
    }
}