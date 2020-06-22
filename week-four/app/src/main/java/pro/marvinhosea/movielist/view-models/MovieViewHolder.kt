package pro.marvinhosea.movielist.`view-models`

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pro.marvinhosea.movielist.R

/**
 * Movie view holder
 */
class MovieViewHolder(movieView: View): RecyclerView.ViewHolder(movieView) {
    val moviePosterImageView: ImageView = movieView.findViewById<ImageView>(R.id.image_view)
    val movieReleaseDate: TextView = movieView.findViewById<TextView>(R.id.release_date)
    val movieName: TextView = movieView.findViewById<TextView>(R.id.movie_name)
    val movieSummary: TextView = movieView.findViewById<TextView>(R.id.movie_summary)
    val movieGenre: TextView = movieView.findViewById<TextView>(R.id.movie_genre)
}