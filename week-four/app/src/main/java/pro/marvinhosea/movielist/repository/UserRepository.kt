package pro.marvinhosea.movielist.repository

interface UserRepository {
    fun registerUser(username: String, password: String)
    fun loginUser(username: String, password: String): Boolean
    fun logoutUser()
    fun isUserLoggedIn(): Boolean
}