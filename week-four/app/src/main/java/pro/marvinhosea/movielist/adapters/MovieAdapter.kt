package pro.marvinhosea.movielist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.data.models.Movie

class MovieAdapter(
    private val movies: MutableList<Movie>,
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

        holder.movieName.text = "Title: ${movies[position].name}"
        holder.movieSummary.text = movies[position].summary
        holder.movieGenre.text = "Genre: ${movies[position].genre}"
        holder.movieReleaseDate.text = "Release date: ${movies[position].releaseDate}"
        holder.moviePosterImageView.setImageResource(movies[position].posterId)

        holder.itemView.setOnClickListener {
            clickListener.movieClicked(movies[position])
        }
    }

    class ViewHolder(movieView: View) : RecyclerView.ViewHolder(movieView) {
        val moviePosterImageView: ImageView = movieView.findViewById(R.id.image_view)
        val movieReleaseDate: TextView = movieView.findViewById(R.id.release_date)
        val movieName: TextView = movieView.findViewById(R.id.movie_name)
        val movieSummary: TextView = movieView.findViewById(R.id.movie_summary)
        val movieGenre: TextView = movieView.findViewById(R.id.movie_genre)
    }
}