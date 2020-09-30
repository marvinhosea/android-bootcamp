package pro.marvinhosea.kardi.db.models.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pro.marvinhosea.kardi.db.models.PlayerHand

@Dao
interface PlayerHandDao {
    @Insert
    suspend fun insertToHand(cards: List<PlayerHand>)

    @Query("SELECT * FROM hands WHERE game_id = :gameId")
    fun getPlayerHand(gameId: Int): LiveData<List<PlayerHand>>
}