package pro.marvinhosea.movielist.controllers

import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.models.Movie

class MovieController {
    //List of my favorite movies
    //The list is private to this class
    private val movies = listOf(
        Movie(1,
            "Mega Mind",
            "Very awesome movie",
            "animation",
            R.drawable.kings_man,
            "20/08/2012"),
        Movie(2,
            "Planet 51",
            "Very awesome movie",
            "animation",
            R.drawable.kings_man,
            "20/08/2012")
    )

    /**
     * Return list of all movies
     *
     * @return List<Movie>
     */
    fun getAllMovies(): List<Movie>{
        return movies
    }
}