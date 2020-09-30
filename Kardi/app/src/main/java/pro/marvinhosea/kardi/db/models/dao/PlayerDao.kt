package pro.marvinhosea.kardi.db.models.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import pro.marvinhosea.kardi.db.models.Player

@Dao
interface PlayerDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertPlayers(players: List<Player>)

    @Query("SELECT * FROM players")
    fun getPlayers(): LiveData<List<Player>>

    @Query("SELECT * FROM players WHERE id = :id")
    suspend fun getPlayer(id: Int): Player

    @Delete
    suspend fun deletePlayer(player: Player)
}