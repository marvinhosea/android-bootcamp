package pro.marvinhosea.movielist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.`view-models`.MovieViewHolder
import pro.marvinhosea.movielist.controllers.MovieController
import pro.marvinhosea.movielist.models.Movie

class MovieAdapter(private val context: Context, private val clickListener: MovieListClickListener): RecyclerView.Adapter<MovieViewHolder>() {

    //Onclick listener for single view holder clicks
    interface MovieListClickListener {
        fun movieClicked(movie: Movie)
    }

    private val movies = MovieController().getAllMovies()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        //Create and inflate view
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

        //Listen to on movie click event
        holder.itemView.setOnClickListener{
            clickListener.movieClicked(movies[position])
        }
    }
}