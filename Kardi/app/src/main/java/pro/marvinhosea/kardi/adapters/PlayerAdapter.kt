package pro.marvinhosea.kardi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import pro.marvinhosea.kardi.R
import pro.marvinhosea.kardi.db.models.Player

class PlayerAdapter(private var players: MutableList<Player>) : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.playerName)
        val initial: TextView = itemView.findViewById(R.id.playerInitial)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.player_holder, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = players.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = players[position].name
        holder.initial.text = players[position].initial
    }
}