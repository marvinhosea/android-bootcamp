package pro.marvinhosea.movielist.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert(onConflict = IGNORE)
    suspend fun insert(movie: Movie)

    @Delete
    fun deleteMovie(vararg movie: Movie)

    @Query("SELECT * FROM movies_table")
    fun getAllMovies(): LiveData<List<Movie>>
}