package pro.marvinhosea.movielist.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import pro.marvinhosea.movielist.data.models.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = IGNORE)
    suspend fun insertSingleMovie(movie: Movie)

    @Delete
    fun deleteMovie(vararg movie: Movie)

    @Query("SELECT * FROM movies_table")
    fun getAllMovies(): LiveData<List<Movie>>
}