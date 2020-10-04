package pro.marvinhosea.kardi.respository

import pro.marvinhosea.kardi.Utility.allCards
import pro.marvinhosea.kardi.db.models.Card
import pro.marvinhosea.kardi.db.models.Game
import pro.marvinhosea.kardi.db.models.KardiDb
import pro.marvinhosea.kardi.db.models.PlayerHand

class GameRepository(private val dbInstance: KardiDb) {

    suspend fun getAllCards(): List<Card> {
        return dbInstance.cardDao().allCards()
    }

    suspend fun dealCards(hands: List<PlayerHand>){
        dbInstance.playerHandDao().insertToHand(hands)
    }

    suspend fun insertGameCards(){
        val cards = allCards();
        dbInstance.cardDao().insertCards(cards)
    }

    suspend fun createGame(game: Game) {
        dbInstance.gameDao().insertGame(game)
    }

    suspend fun getGameByCode(code: String): Game{
        return dbInstance.gameDao().getGameByCode(code)
    }
}