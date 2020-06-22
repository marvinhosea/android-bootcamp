package pro.marvinhosea.movielist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.`view-models`.MovieViewHolder
import pro.marvinhosea.movielist.controllers.MovieController
import pro.marvinhosea.movielist.models.Movie

class MovieAdapter(private val context: Context, val clickListener: MovieListClickListener): RecyclerView.Adapter<MovieViewHolder>() {

    interface MovieListClickListener {
        fun movieClicked(movie: Movie)
    }
    val movies = MovieController().getAllMovies()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_view_holder, parent, false)

        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieName.text = context.getString(R.string.movie_name_text, movies[position].name)
        holder.movieSummary.text = movies[position].summary
        holder.movieGenre.text = context.getString(R.string.movie_genre , movies[position].genre)
        holder.movieReleaseDate.text = context.getString(R.string.movie_release_date_text, movies[position].releaseDate)
        holder.moviePosterImageView.setImageResource(movies[position].posterId)

        holder.itemView.setOnClickListener{
            clickListener.movieClicked(movies[position])
        }
    }
}