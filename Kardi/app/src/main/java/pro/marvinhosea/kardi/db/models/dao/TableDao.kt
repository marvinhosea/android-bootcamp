package pro.marvinhosea.kardi.db.models.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import pro.marvinhosea.kardi.db.models.Table

@Dao
interface TableDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertCard(table: Table)

    @Query("SELECT * FROM tables")
    fun getTables(): LiveData<List<Table>>

    @Query("SELECT * FROM tables WHERE game_id = :gameId")
    fun getGameTables(gameId: Int): LiveData<List<Table>>
}