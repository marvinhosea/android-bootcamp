package pro.marvinhosea.kardi.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import pro.marvinhosea.kardi.KardiApp
import pro.marvinhosea.kardi.R
import pro.marvinhosea.kardi.adapters.CardAdapter
import pro.marvinhosea.kardi.adapters.PlayerAdapter
import pro.marvinhosea.kardi.adapters.SelectedCardAdapter
import pro.marvinhosea.kardi.db.models.Card
import pro.marvinhosea.kardi.db.models.KardiDb
import pro.marvinhosea.kardi.db.models.Player
import pro.marvinhosea.kardi.respository.GameRepository

class GameFragment : Fragment() {

    private lateinit var gameModelView: GameViewModel
    private lateinit var fanLayoutManager: FanLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_layout, container, false)
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fanLayoutSetting: FanLayoutManagerSettings = FanLayoutManagerSettings
            .newBuilder(activity)
            .withFanRadius(true)
            .withAngleItemBounce(0F)
            .build()
        fanLayoutManager = activity?.let { FanLayoutManager(it, fanLayoutSetting) }!!
        userCardsRecycleView.layoutManager = fanLayoutManager
        lifecycleScope.launch {
            gameModelView = GameViewModel(GameRepository(KardiDb.getInstance(KardiApp.getAppContext()).cardDao()))
            val cards = gameModelView.dealCards()
            userCardsRecycleView.adapter = CardAdapter(cards)
        }

//        selectedCardsRecycleView.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        playersRecycleView.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        val players = mutableListOf<Player>()
        players.addAll(arrayListOf(Player(1,"Marvin", "MC"), Player(2,"Wanguba", "EC"), Player(3, "Murimi", "MK")))

        playersRecycleView.adapter = PlayerAdapter(players)
//        selectedCardsRecycleView.adapter = SelectedCardAdapter(cards)
    }
}