package pro.marvinhosea.kardi.db.models.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import pro.marvinhosea.kardi.db.models.Card

@Dao
interface CardDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertCards(cards: List<Card>)

    @Update
    suspend fun updateCard(card: Card)

    @Query("SELECT * FROM cards")
    fun allCards(): LiveData<List<Card>>
}