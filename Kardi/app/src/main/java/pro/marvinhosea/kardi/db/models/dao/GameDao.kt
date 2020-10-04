package pro.marvinhosea.kardi.db.models.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import pro.marvinhosea.kardi.db.models.Game

@Dao
interface GameDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM games WHERE id = :id")
    suspend fun selectGame(id: Int): Game

    @Query("SELECT * FROM games")
    fun allGames(): LiveData<List<Game>>

    @Query("SELECT * FROM games WHERE code = :code LIMIT 1")
    suspend fun getGameByCode(code: String): Game
}