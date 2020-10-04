package pro.marvinhosea.kardi.db.models.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import pro.marvinhosea.kardi.db.models.GamePlayer

@Dao
interface GamePlayerDao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(gamePlayers: List<GamePlayer>)
}