package pro.marvinhosea.movielist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import pro.marvinhosea.movielist.MainActivity
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.models.Movie

class MovieDetailFragment() : Fragment() {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            movie = it.getParcelable(ARG_LIST)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        detail_image_view.setImageResource(movie.posterId)
//        detail_movie_name.text = getString(R.string.movie_name_text, movie.name)
//        detail_movie_genre.text = getString(R.string.movie_genre, movie.genre)
//        detail_release_date.text = getString(R.string.movie_release_date_text, movie.releaseDate)
//        detail_movie_summary.text = movie.summary
    }

    companion object {

        private val ARG_LIST = "movies"

        fun newInstance(movie: Movie): MovieDetailFragment{
            val bundle = Bundle()
            bundle.putParcelable(ARG_LIST, movie)
            val fragment = MovieDetailFragment()
            fragment.arguments = bundle

            return fragment
        }
    }
}