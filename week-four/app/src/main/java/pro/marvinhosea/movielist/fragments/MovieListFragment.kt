package pro.marvinhosea.movielist.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.adapters.MovieAdapter
import pro.marvinhosea.movielist.models.Movie

class MovieListFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        movieRecyclerView.adapter = MovieAdapter(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    companion object {
        fun newInstance(): MovieListFragment {
            return MovieListFragment()
        }
    }

    interface OnFragmentInteractionListener{
        fun movieClicked(movie: Movie)
    }

    fun showMovie(movie: Movie){
        listener?.movieClicked(movie)
    }
}