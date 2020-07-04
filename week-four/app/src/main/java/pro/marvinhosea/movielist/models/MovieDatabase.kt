package pro.marvinhosea.movielist.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Movie::class], version = 1, exportSchema = false)
public abstract class MovieDatabase : RoomDatabase(){
    abstract fun movieDao():MovieDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase? {
            when (INSTANCE) {
                null -> INSTANCE = Room.databaseBuilder(
                    context, MovieDatabase::class.java,
                    "movielist"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}