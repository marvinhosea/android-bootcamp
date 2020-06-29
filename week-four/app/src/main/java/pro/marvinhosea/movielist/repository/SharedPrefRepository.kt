package pro.marvinhosea.movielist.repository

import android.content.Context
import androidx.preference.PreferenceManager

object SharedPrefRepository: UserRepository {
    
    private lateinit var applicationContext: Context
    const val USERNAME = "USERNAME"
    const val USER_PASSWORD = "USER_PASSWORD"

    private fun sharedPreps() = PreferenceManager.getDefaultSharedPreferences(applicationContext)

    fun init(context: Context){
        applicationContext = context
    }

    override fun registerUser(username: String, password: String) {
        val editor = sharedPreps().edit();

        editor.putString(USERNAME, username).apply()
        editor.putString(USER_PASSWORD, password).apply()
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

        return true
    }

    override fun clearUser() {
        TODO("Not yet implemented")
    }
}