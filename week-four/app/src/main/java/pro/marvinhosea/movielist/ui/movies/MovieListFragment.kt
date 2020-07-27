package pro.marvinhosea.movielist.ui.movies

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.coroutines.launch
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.ui.movies.show.MovieDetailActivity
import pro.marvinhosea.movielist.adapters.MovieAdapter
import pro.marvinhosea.movielist.data.models.*
import pro.marvinhosea.movielist.ui.login.UserLoginActivity

class MovieListFragment : Fragment(), MovieAdapter.MovieListClickListener {
    private val movieViewModel by lazy { ViewModelProvider(this).get(MovieViewModel::class.java) }
    private val adapter by lazy { MovieAdapter(mutableListOf(), this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieRecyclerView.adapter = adapter
        movieViewModel.getAllMovies().observe(viewLifecycleOwner, Observer<List<Movie>> { movies ->
            adapter.setData(movies)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.watch_list -> myWatchList()
            R.id.top_rate -> getMoviesByCategory(TOP_RATED_CATEGORY)
            R.id.popular_movies -> getMoviesByCategory(POPULAR_CATEGORY)
            R.id.now_playing -> getMoviesByCategory(NOW_PLAYING_CATEGORY)
            R.id.upcoming_movies -> getMoviesByCategory(UPCOMING_CATEGORY)
            R.id.logout_menu -> logOut()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getMoviesByCategory(category: String) {
        movieViewModel.getMoviesByCategory(category).observe(this, Observer<List<Movie>> { movies ->
            adapter.setData(movies)
        })
    }

    private fun myWatchList() {
        lifecycleScope.launch {
            (activity as AppCompatActivity).supportActionBar?.title = "My Watchlist"
            adapter.setData(movieViewModel.myWatchListMovies())
        }
    }

    private fun logOut() {
        activity?.applicationContext?.let { movieViewModel.logoutUser(it) }

        val intent = Intent(activity, UserLoginActivity::class.java)
        startActivity(intent)
        activity?.finish()
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
        movieDetailsIntent.putExtra(getString(R.string.MOVIE_INTENT), movie.id.toString())
        startActivity(movieDetailsIntent)
    }
}