package pro.marvinhosea.kardi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pro.marvinhosea.kardi.db.models.Card
import pro.marvinhosea.kardi.respository.GameRepository

class HomeViewModel(private val gameRepository: GameRepository) : ViewModel() {
    suspend fun getAllCards(): List<Card> {
        return gameRepository.getAllCards();
    }

    suspend fun insertCards(){
        gameRepository.insertGameCards()
    }
}