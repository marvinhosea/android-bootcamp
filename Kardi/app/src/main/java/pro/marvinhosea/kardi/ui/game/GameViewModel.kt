package pro.marvinhosea.kardi.ui.game

import androidx.lifecycle.ViewModel
import pro.marvinhosea.kardi.db.models.Card
import pro.marvinhosea.kardi.respository.GameRepository

class GameViewModel(private val gameRepository: GameRepository) : ViewModel() {
    suspend fun getAllCards(): List<Card> {
        return gameRepository.getAllCards()
    }
}