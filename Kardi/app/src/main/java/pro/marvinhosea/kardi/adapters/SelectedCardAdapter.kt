package pro.marvinhosea.kardi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pro.marvinhosea.kardi.R
import pro.marvinhosea.kardi.db.models.Card

class SelectedCardAdapter(private var cards: MutableList<Card>) : RecyclerView.Adapter<SelectedCardAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardImage: ImageView = itemView.findViewById(R.id.selectedCardImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.selected_cards_holder, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(R.drawable.nine_flower)
            .placeholder(R.drawable.nine_flower)
            .error(R.drawable.nine_flower)
            .into(holder.cardImage)
    }
}