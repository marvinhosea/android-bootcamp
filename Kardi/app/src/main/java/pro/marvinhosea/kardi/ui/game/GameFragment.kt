package pro.marvinhosea.kardi.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.cleveroad.fanlayoutmanager.FanLayoutManager
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings
import kotlinx.android.synthetic.main.game_layout.*
import pro.marvinhosea.kardi.R
import pro.marvinhosea.kardi.adapters.CardAdapter
import pro.marvinhosea.kardi.adapters.PlayerAdapter
import pro.marvinhosea.kardi.adapters.SelectedCardAdapter
import pro.marvinhosea.kardi.db.models.Card
import pro.marvinhosea.kardi.db.models.Player

class GameFragment : Fragment() {

    private lateinit var gameModel: GameViewModel
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
        selectedCardsRecycleView.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        playersRecycleView.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        val cards = mutableListOf<Card>()
        val players = mutableListOf<Player>()
        players.addAll(arrayListOf(Player("Marvin", "MC"), Player("Wanguba", "EC"), Player("Murimi", "MK")))
        for (i in 1..52){
            cards.add(Card(
                "spade",
                "red",
                "34",
                "A",
                10
            ))
        }
        userCardsRecycleView.adapter = CardAdapter(cards)
        playersRecycleView.adapter = PlayerAdapter(players)
        selectedCardsRecycleView.adapter = SelectedCardAdapter(cards)
    }
}