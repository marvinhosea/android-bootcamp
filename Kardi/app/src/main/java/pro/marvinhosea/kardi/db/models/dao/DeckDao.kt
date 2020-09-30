package pro.marvinhosea.kardi.db.models.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import pro.marvinhosea.kardi.db.models.Deck

@Dao
interface DeckDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertDeck(deck: Deck)

    @Query("SELECT * FROM decks")
    fun allDecks(): LiveData<List<Deck>>

    @Query("SELECT * FROM decks WHERE game_id = :gameId")
    suspend fun getGameDeck(gameId: Int): Deck
}