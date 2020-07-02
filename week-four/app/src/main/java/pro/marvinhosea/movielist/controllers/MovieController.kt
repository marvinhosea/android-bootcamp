package pro.marvinhosea.movielist.controllers

import pro.marvinhosea.movielist.R
import pro.marvinhosea.movielist.models.Movie
import java.util.*

object MovieController {

    private val movies = listOf(
        Movie(UUID.randomUUID().toString(),
            "Mega Mind",
            "The supervillain Megamind finally defeats his nemesis, the superhero Metro Man. But without a hero, he loses all purpose and must find new meaning to his life.",
            "animation",
            R.drawable.megamind,
            "05/11/2010"),
        Movie(UUID.randomUUID().toString(),
            "Adams Family",
            "The eccentrically macabre family moves to a bland suburb where Wednesday Addams' friendship with the daughter of a hostile and conformist local reality show host exacerbates conflict between the families.",
            "animation",
            R.drawable.addams,
            "11/09/2012"),
        Movie(UUID.randomUUID().toString(),
            "Brave",
            "Determined to make her own path in life, Princess Merida (Kelly Macdonald) defies a custom that brings chaos to her kingdom. Granted one wish, Merida must rely on her bravery and her archery skills to undo a beastly curse.",
            "animation",
            R.drawable.brave,
            "22/06/2012"),
        Movie(UUID.randomUUID().toString(),
            "The Grinch",
            "A grumpy Grinch (Benedict Cumberbatch) plots to ruin Christmas for the village of Whoville.",
            "animation",
            R.drawable.grinch,
            "09/11/2018"),
        Movie(UUID.randomUUID().toString(),
            "Minions ",
            "Minions Stuart, Kevin, and Bob are recruited by Scarlet Overkill, a supervillain who, alongside her inventor husband Herb, hatches a plot to take over the world.",
            "animation",
            R.drawable.minions,
            "10/07/2015"),
        Movie(UUID.randomUUID().toString(),
            "Peninsula",
            "Sequel to the 2016 South Korean zombie film.",
            "Action",
            R.drawable.peninsula,
            "12/08/2020"),
        Movie(UUID.randomUUID().toString(),
            "Scoob",
            "Scooby and the gang face their most challenging mystery ever: a plot to unleash the ghost dog Cerberus upon the world. As they race to stop this dogpocalypse, the gang discovers that Scooby has an epic destiny greater than anyone imagined.",
            "Animation",
            R.drawable.scoob,
            "15/05/2020"),
        Movie(UUID.randomUUID().toString(),
            "The Smurfs",
            "When the evil wizard Gargamel chases the tiny blue Smurfs out of their village, they tumble from their magical world into New York City.",
            "Animation",
            R.drawable.smurfs,
            "29/07/2011"),
        Movie(UUID.randomUUID().toString(),
            "Spider-Man: Into the Spider-Verse",
            "Teen Miles Morales becomes Spider-Man of his reality, crossing his path with five counterparts from other dimensions to stop a threat for all realities.",
            "Animation",
            R.drawable.spiderverse,
            "14/12/2018")
    )

    /**
     * Return list of all movies
     *
     * @return List<Movie>
     */
    fun getAllMovies(): List<Movie>{
        return movies
    }

    fun getMovie(): Movie = movies.random()
}