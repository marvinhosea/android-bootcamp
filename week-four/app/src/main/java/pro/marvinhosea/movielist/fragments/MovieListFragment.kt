package pro.marvinhosea.movielist.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movie_list.*
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.adapters.MovieAdapter
import pro.marvinhosea.movielist.models.Movie

class MovieListFragment : Fragment(), MovieAdapter.MovieListClickListener {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener){
            listener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieRecyclerView.adapter = MovieAdapter(this)
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
        fun onMovieListClicked(movie: Movie)
    }

    override fun movieClicked(movie: Movie) {
        listener?.onMovieListClicked(movie)
    }
}