package pro.marvinhosea.movielist.`view-models`

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_view_holder.view.*
import pro.marvinhosea.movielist.R

class MovieViewHolder(movieView: View): RecyclerView.ViewHolder(movieView) {
    val moviePosterImageView = movieView.findViewById<ImageView>(R.id.image_view)
    val movieReleaseDate = movieView.findViewById<TextView>(R.id.release_date)
    val movieName = movieView.findViewById<TextView>(R.id.movie_name)
    val movieSummary = movieView.findViewById<TextView>(R.id.movie_summary)
    val movieGenre = movieView.findViewById<TextView>(R.id.movie_genre)

        //Not really required
//    val movieId = movieView.findViewById<TextView>(R.id.)
}