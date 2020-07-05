package pro.marvinhosea.movielist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.data.models.Movie

class MovieAdapter(
    private val movies: List<Movie>,
    private val clickListener: MovieListClickListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    interface MovieListClickListener {
        fun movieClicked(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_view_holder, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.movieName.text = movies[position].name

        Picasso.get()
            .load(movies[position].posterLink)
            .error(R.drawable.grinch)
            .placeholder(R.drawable.grinch)
            .into(holder.moviePosterImageView)

        holder.itemView.setOnClickListener {
            clickListener.movieClicked(movies[position])
        }
    }

    class ViewHolder(movieView: View) : RecyclerView.ViewHolder(movieView) {
        val moviePosterImageView: ImageView = movieView.findViewById(R.id.image_view)
        val movieName: TextView = movieView.findViewById(R.id.movie_name)
    }
}