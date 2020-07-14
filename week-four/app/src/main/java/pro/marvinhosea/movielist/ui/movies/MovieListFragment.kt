package pro.marvinhosea.movielist.ui.movies

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.coroutines.launch
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.ui.movies.show.MovieDetailActivity
import pro.marvinhosea.movielist.adapters.MovieAdapter
import pro.marvinhosea.movielist.data.models.Success
import pro.marvinhosea.movielist.data.models.response.Result
import pro.marvinhosea.movielist.networking.NetworkStatusChecker
import pro.marvinhosea.movielist.networking.RemoteApi
import pro.marvinhosea.movielist.networking.buildApiService
import pro.marvinhosea.movielist.utils.toast

class MovieListFragment : Fragment(), MovieAdapter.MovieListClickListener {
    private val movieViewModel by lazy {
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }

    private val adapter by lazy { MovieAdapter(mutableListOf(), this) }

    private val networkStatusChecker by lazy {
        activity?.getSystemService(ConnectivityManager::class.java)?.let { NetworkStatusChecker(it) }
    }

    private val apiService by lazy { buildApiService() }

    private val remoteApi by lazy {
        RemoteApi(apiService)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieRecyclerView.adapter = adapter

        if (!networkStatusChecker?.hasInternetConnection()!!) {
            requireContext().toast("No Internet Connection")
            return
        }

        getUpcomingMovies()
    }

    private fun getUpcomingMovies() {
        lifecycleScope.launch {
            val results = remoteApi.getUpcomingMovies()

            if (results is Success) {
                
                adapter.setData(results.data)
            } else {
                Log.d("Error1", "testing ${results.toString()}")
                Toast.makeText(activity, "Unable to load images", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun movieClicked(movie: Result) {
        val movieDetailsIntent = Intent(requireContext(), MovieDetailActivity::class.java)
        movieDetailsIntent.putExtra(getString(R.string.MOVIE_INTENT), movie.id)
        startActivity(movieDetailsIntent)
    }
}