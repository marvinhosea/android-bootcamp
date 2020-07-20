package pro.marvinhosea.movielist.ui.movies

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.coroutines.launch
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.ui.movies.show.MovieDetailActivity
import pro.marvinhosea.movielist.adapters.MovieAdapter
import pro.marvinhosea.movielist.data.models.Movie
import pro.marvinhosea.movielist.networking.NetworkStatusChecker
import pro.marvinhosea.movielist.networking.RemoteApi
import pro.marvinhosea.movielist.networking.buildApiService
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository
import pro.marvinhosea.movielist.ui.login.UserLoginActivity

class MovieListFragment : Fragment(), MovieAdapter.MovieListClickListener {
    private val movieViewModel by lazy { ViewModelProvider(this).get(MovieViewModel::class.java) }
    private var userSharedRepository = UserSharedPrefRepository
    private val adapter by lazy { MovieAdapter(mutableListOf(), this) }
//    private val networkStatusChecker by lazy { activity?.getSystemService(ConnectivityManager::class.java)?.let { NetworkStatusChecker(it) } }
    private val apiService by lazy { buildApiService() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieRecyclerView.adapter = adapter
//        if (!networkStatusChecker?.hasInternetConnection()!!) {
//            requireContext().toast("No Internet Connection")
            lifecycleScope.launch {
                adapter.setData(movieViewModel.getAllMovies())
            }
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.watch_list -> myWatchList()
//            R.id.top_rate -> getMovies("Top Rated Movies")
//            R.id.popular_movies -> getMovies("Popular movies")
//            R.id.now_playing -> getMovies("Now Playing Movies")
//            R.id.upcoming_movies -> getMovies("Upcoming Movies")
            R.id.logout_menu -> logOut()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun myWatchList() {
        lifecycleScope.launch {
            (activity as AppCompatActivity).supportActionBar?.title = "My Watchlist"
            adapter.setData(movieViewModel.myWatchListMovies())
        }
    }

    private fun logOut() {
        activity?.applicationContext?.let { userSharedRepository.init(it) }
        userSharedRepository.logoutUser()

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