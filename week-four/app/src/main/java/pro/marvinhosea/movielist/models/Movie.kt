package pro.marvinhosea.movielist.models

data class Movie(
    val id: Int,
    val name: String,
    val summary: String,
    val genre: String,
    val posterId: Int,
    val releaseDate: String
) {
}