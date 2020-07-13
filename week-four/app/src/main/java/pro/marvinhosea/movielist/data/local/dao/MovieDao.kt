package pro.marvinhosea.movielist.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import pro.marvinhosea.movielist.data.models.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = REPLACE)
    suspend fun storeMovie(movie: Movie)

    @Insert(onConflict = IGNORE)
    fun storeMovies(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("SELECT * FROM movies WHERE id = :id")
    fun fetchMovieById(id: String): LiveData<Movie>

    @Query("SELECT * FROM movies")
    fun fetchMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movies")
    suspend fun fetchAllMovies(): List<Movie>
}