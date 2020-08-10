package pro.marvinhosea.movielist.repository

import android.content.Context
import androidx.preference.PreferenceManager

object UserSharedPrefRepository : UserRepository {
    private lateinit var applicationContext: Context
    private const val USERNAME = "USERNAME"
    private const val USER_PASSWORD = "USER_PASSWORD"
    private const val USER_IS_LOGGED_IN = "USER_IS_LOGGED_IN"
    private fun sharedPreps() = PreferenceManager.getDefaultSharedPreferences(applicationContext)

    fun init(context: Context) {
        applicationContext = context
    }

    /**
     * Register user on shared preference
     */
    override fun registerUser(username: String, password: String) {
        val editor = sharedPreps().edit()
        editor.putString(USERNAME, username).apply()
        editor.putString(USER_PASSWORD, password).apply()
        editor.putBoolean(USER_IS_LOGGED_IN, true).apply()
    }

    /**
     * Login in user by checking user validity
     */
    override fun loginUser(username: String, password: String): Boolean {
        val getUsername = sharedPreps().getString(USERNAME, "")
        val getPassword = sharedPreps().getString(USER_PASSWORD, "")

        if (getUsername == null || getPassword == null) {
            return false
        }
        if (getUsername.isEmpty()) {
            return false
        }
        if (getPassword.length < 4) {
            return false
        }
        val editor = sharedPreps().edit()
        editor.putBoolean(USER_IS_LOGGED_IN, true).apply()

        return true
    }

    /**
     * Logout user and remove user from shared preference
     */
    override fun logoutUser() {
        sharedPreps().edit().remove(USER_IS_LOGGED_IN).apply()
    }

    /**
     * Check if user is logged in by checking if @param{USER_IS_LOGGED_IN} is true
     */
    override fun isUserLoggedIn(): Boolean {
        return sharedPreps().getBoolean(USER_IS_LOGGED_IN, false)
    }

    fun getUserName(): String {
        return sharedPreps().getString(USERNAME, "")!!
    }
}