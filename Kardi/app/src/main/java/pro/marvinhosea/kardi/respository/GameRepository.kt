package pro.marvinhosea.kardi.respository

import android.util.Log
import androidx.lifecycle.LiveData
import pro.marvinhosea.kardi.Utility.allCards
import pro.marvinhosea.kardi.db.models.Card
import pro.marvinhosea.kardi.db.models.KardiDb
import pro.marvinhosea.kardi.db.models.dao.CardDao

class GameRepository(private val dbInstance: KardiDb) {

    fun getAllCards(): LiveData<List<Card>> {
        return dbInstance.cardDao().allCards()
    }

    suspend fun setGameCards(): MutableList<Card> {
        val gameCards = allCards()
        Log.d("See cards", gameCards.toString())
        return gameCards
    }
}