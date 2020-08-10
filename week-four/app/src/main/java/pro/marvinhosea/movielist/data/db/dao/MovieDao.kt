package pro.marvinhosea.movielist.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import pro.marvinhosea.movielist.data.models.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = IGNORE)
    suspend fun storeMovies(movies: List<Movie>)

    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun fetchMovieById(id: Int): Movie

    @Query("SELECT * FROM movies")
    fun fetchMovies(): LiveData<List<Movie>>

    @Update
    suspend fun updateMovie(movie: Movie)

    @Query("SELECT * FROM movies WHERE userName = :userName AND inWatchList = :inWatchlist")
    suspend fun fetchMyWatchlistMovies(userName: String, inWatchlist: Boolean): List<Movie>

    @Query("SELECT * FROM movies WHERE category = :category")
    fun fetchByCategory(category: String): LiveData<List<Movie>>
}