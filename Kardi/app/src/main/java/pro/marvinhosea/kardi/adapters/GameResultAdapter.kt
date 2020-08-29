package pro.marvinhosea.kardi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pro.marvinhosea.kardi.R
import pro.marvinhosea.kardi.db.models.GameResult

class GameResultAdapter(private var results: MutableList<GameResult>): RecyclerView.Adapter<GameResultAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val gameId: TextView = itemView.findViewById(R.id.gameId)
        val winner: TextView = itemView.findViewById(R.id.winner)
        val points: TextView = itemView.findViewById(R.id.point)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.game_result_holder_layout, parent, false))
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gameId.text = results[position].gameId
        holder.winner.text = results[position].winner
        holder.points.text = results[position].points.toString()
    }
}