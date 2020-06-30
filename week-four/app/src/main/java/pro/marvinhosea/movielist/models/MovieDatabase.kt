package pro.marvinhosea.movielist.models

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [Movie::class], version = 1, exportSchema = false)
public abstract class MovieDatabase : RoomDatabase(){
    abstract fun movieDao():MovieDao

    companion object{
        var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }

        }
    }
}