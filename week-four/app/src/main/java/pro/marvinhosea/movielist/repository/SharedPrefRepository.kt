package pro.marvinhosea.movielist.repository

import android.content.Context
import androidx.preference.PreferenceManager

object SharedPrefRepository: UserRepository {

    private lateinit var applicationContext: Context
    const val USERNAME = "USERNAME"
    const val USER_PASSWORD = "USER_PASSWORD"
    const val USER_IS_LOGGED_IN = "USER_IS_LOGGED_IN"

    private fun sharedPreps() = PreferenceManager.getDefaultSharedPreferences(applicationContext)

    fun init(context: Context){
        applicationContext = context
    }

    override fun registerUser(username: String, password: String) {
        val editor = sharedPreps().edit()

        editor.putString(USERNAME, username).apply()
        editor.putString(USER_PASSWORD, password).apply()
        editor.putBoolean(USER_IS_LOGGED_IN, true).apply()
    }

    override fun loginUser(username: String, password: String): Boolean {
        val getUsername = sharedPreps().getString(USERNAME,"")
        val getPassword = sharedPreps().getString(USER_PASSWORD, "")

        if (getUsername?.length!! < 1 || !username.equals(getUsername) ){
            return  false
        }

        if (getPassword?.length!! < 4 || !username.equals(getPassword) ){
            return  false
        }

        val editor = sharedPreps().edit()
        editor.putBoolean(USER_IS_LOGGED_IN, true).apply()

        return true
    }

    override fun logoutUser() {
        sharedPreps().edit().clear().apply()
    }

    override fun isUserLoggedIn(): Boolean {
        return sharedPreps().getBoolean(USER_IS_LOGGED_IN, false)
    }
}