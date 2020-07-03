package pro.marvinhosea.movielist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository

class UserLoginActivity : AppCompatActivity() {

    private val repository = UserSharedPrefRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        repository.init(this)
        title = "User Login"

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener {
            val getUsername = username.text.toString()
            val getPassword = password.text.toString()

            val loginValidationMessage = checkIfLoginIsValid(getUsername, getPassword)

            if (loginValidationMessage.first) {
                val intent = Intent(this, MainActivity::class.java)

                Toast.makeText(this, loginValidationMessage.second, Toast.LENGTH_LONG).show()
                startActivity(intent)
            }

            Toast.makeText(this, loginValidationMessage.second, Toast.LENGTH_LONG).show()
        }
    }

    private fun checkIfLoginIsValid(username: String, password: String): Pair<Boolean, String> {

        if (username.isEmpty()) {
            return Pair(false, "Username cannot be empty")
        }

        if (password.length < 4) {
            return Pair(false, "The password cannot be less than four letters")
        }

        if (!repository.loginUser(username, password)) {
            repository.registerUser(username, password)
            return Pair(true, "Registered successfully")
        }

        return Pair(true, "Login successful")
    }
}