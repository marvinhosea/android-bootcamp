package pro.marvinhosea.movielist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pro.marvinhosea.movielist.App
import pro.marvinhosea.movielist.data.db.dao.MovieDao
import pro.marvinhosea.movielist.data.models.Movie

@Database(entities = [Movie::class], version = 6, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(): MovieDatabase {

            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(App.getAppContext(), MovieDatabase::class.java, "movielist")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}