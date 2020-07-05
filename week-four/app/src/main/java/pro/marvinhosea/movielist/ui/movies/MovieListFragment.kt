package pro.marvinhosea.movielist.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_movie_list.*
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.activities.MovieDetailActivity
import pro.marvinhosea.movielist.ui.movies.MovieViewModel
import pro.marvinhosea.movielist.adapters.MovieAdapter
import pro.marvinhosea.movielist.data.models.Movie

class MovieListFragment : Fragment(), MovieAdapter.MovieListClickListener {
    private val movieViewModel by lazy {
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieViewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            movieRecyclerView.adapter = MovieAdapter(movies, this)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun movieClicked(movie: Movie) {
        val movieDetailsIntent = Intent(requireContext(), MovieDetailActivity::class.java)
        movieDetailsIntent.putExtra(getString(R.string.MOVIE_INTENT), movie)
        startActivity(movieDetailsIntent)
    }
}