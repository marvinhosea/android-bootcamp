package pro.marvinhosea.kardi.ui.game

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_game_dash_board.*
import pro.marvinhosea.kardi.R
import pro.marvinhosea.kardi.adapters.GameResultAdapter
import pro.marvinhosea.kardi.db.models.GameResult

class GameDashBoardFragment : Fragment() {

    private lateinit var adapter: GameResultAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_dash_board, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        playGame.setOnClickListener {
            startGame()
        }
        gameResults.layoutManager = LinearLayoutManager(activity)
        val results = mutableListOf<GameResult>()
        for (i in 1..56){
            results.add(GameResult(
                "GAMEID $i",
                "Marvin Collins",
                i
            ))
        }
        gameResults.adapter = GameResultAdapter(results)
    }

    fun startGame() {
        val gameActivity = Intent(activity, GameActivity::class.java)
        startActivity(gameActivity)
    }
}