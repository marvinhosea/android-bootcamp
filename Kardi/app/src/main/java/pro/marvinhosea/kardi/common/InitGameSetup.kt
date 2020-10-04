package pro.marvinhosea.kardi.common

import android.util.Log
import org.koin.java.KoinJavaComponent.inject
import pro.marvinhosea.kardi.KardiApp
import pro.marvinhosea.kardi.db.models.Card
import pro.marvinhosea.kardi.db.models.Game
import pro.marvinhosea.kardi.db.models.KardiDb
import pro.marvinhosea.kardi.db.models.Player
import pro.marvinhosea.kardi.respository.GameRepository

class InitGameSetup(private val cards: MutableList<Card>, private val players: MutableList<Player>) {
    private lateinit var gameRepository: GameRepository
    fun dealCards(){
        Log.d("Number of players", cards.size.toString())
    }

    suspend fun createGame(game: Game): Game {
        gameRepository = GameRepository(KardiDb.getInstance(KardiApp.getAppContext()))
        gameRepository.createGame(game)
        return gameRepository.getGameByCode(game.code)
    }
}