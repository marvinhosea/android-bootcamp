package pro.marvinhosea.movielist.ui.movies.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_add_movie.*
import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.data.models.Movie
import java.util.*

class AddMovieActivity : AppCompatActivity() {
    private lateinit var addMovieViewModel: AddMovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        addMovieViewModel = ViewModelProvider(this).get(AddMovieViewModel::class.java)

        addMovieButton.setOnClickListener {
            val movieName = addMovieName.text.toString()
            val movieGenre = addMovieGenre.text.toString()
            val movieReleaseDate = addMovieReleaseDate.text.toString()
            val moviePosterLink = addMoviePostLink.text.toString()
            val movieSummary = addMovieSummary.text.toString()
            val isInputValid = validateMovieInput(movieName, movieGenre, movieReleaseDate, moviePosterLink, movieSummary)

            if (isInputValid.first) {
                val movie = Movie(
                    UUID.randomUUID().toString(),
                    movieName,
                    movieSummary,
                    movieGenre,
                    moviePosterLink,
                    movieReleaseDate
                )

                addMovieViewModel.createMovie(movie)
                Toast.makeText(this, isInputValid.second, Toast.LENGTH_LONG).show()
                this.finish()
            } else {
                Toast.makeText(this, isInputValid.second, Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun validateMovieInput(
        movieName: String,
        movieGenre: String,
        movieReleaseDate: String,
        moviePosterLink: String,
        movieSummary: String
    ): Pair<Boolean, String> {

        if (movieName.isEmpty()) {
            return Pair(false, "Movie name cannot be empty")
        }

        if (movieGenre.isEmpty()) {
            return Pair(false, "Movie genre cannot be empty")
        }

        if (movieReleaseDate.isEmpty()) {
            return Pair(false, "Movie release date cannot be empty")
        }

        if (moviePosterLink.isEmpty()) {
            return Pair(false, "Movie poster link cannot be empty")
        }

        if (!URLUtil.isValidUrl(moviePosterLink)) {
            return Pair(false, "Invalid link")
        }

        if (movieSummary.isEmpty()) {
            return Pair(false, "Movie release date cannot be empty")
        }

        return Pair(true, "Movie added successful")
    }
}