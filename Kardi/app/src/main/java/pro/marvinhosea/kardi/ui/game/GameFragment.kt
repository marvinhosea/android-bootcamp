package pro.marvinhosea.kardi.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cleveroad.fanlayoutmanager.FanLayoutManager
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.game_layout.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import pro.marvinhosea.kardi.KardiApp
import pro.marvinhosea.kardi.R
import pro.marvinhosea.kardi.adapters.CardAdapter
import pro.marvinhosea.kardi.adapters.PlayerAdapter
import pro.marvinhosea.kardi.adapters.SelectedCardAdapter
import pro.marvinhosea.kardi.common.InitGameSetup
import pro.marvinhosea.kardi.db.models.*
import pro.marvinhosea.kardi.respository.GameRepository
import java.time.LocalDate
import java.time.LocalDateTime

class GameFragment : Fragment() {
    private val gameModelView by inject<GameViewModel>()
    private lateinit var fanLayoutManager: FanLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fanLayoutSetting: FanLayoutManagerSettings = FanLayoutManagerSettings
            .newBuilder(activity)
            .withFanRadius(true)
            .withAngleItemBounce(0F)
            .build()
        fanLayoutManager = activity?.let { FanLayoutManager(it, fanLayoutSetting) }!!
//        userCardsRecycleView.layoutManager = fanLayoutManager
        initGame()

//        selectedCardsRecycleView.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
//        playersRecycleView.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)

//        playersRecycleView.adapter = PlayerAdapter(players)
//        selectedCardsRecycleView.adapter = SelectedCardAdapter(cards)
    }

    private fun initGame(): Unit {
        lifecycleScope.launch {
            val cards = gameModelView.getAllCards()
            val players = mutableListOf<Player>()
            players.addAll(arrayListOf(Player(1,"Marvin", "MC"), Player(2,"Wanguba", "EC"), Player(3, "Murimi", "MK")))

            val initGameSetup = InitGameSetup(cards.toMutableList(), players)
            val randomCode = (10000..1000000).shuffled().first()

            val game = initGameSetup.createGame(Game(
                null,
                "Demo Game",
                randomCode.toString(),
                true
            ))

            Toast.makeText(activity, game.code, Toast.LENGTH_LONG).show()
        }
    }
}