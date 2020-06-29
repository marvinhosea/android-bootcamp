package pro.marvinhosea.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import pro.marvinhosea.movielist.repository.SharedPrefRepository

class UserLoginActivity : AppCompatActivity() {

    private val repositiry = SharedPrefRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        repositiry.init(this)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener{ view ->
            val getUsername = username.text.toString()
            val getPassword = password.text.toString()

            val loginValidationMessage = checkIfLoginIsValid(getUsername, getPassword)

            Toast.makeText(this, loginValidationMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun checkIfLoginIsValid(username: String, password: String): String{

        if (username.isEmpty()){
            return "Username cannot be empty"
        }

        if (password.length < 4){
            return "The password cannot be less than four letters"
        }

        if (!repositiry.loginUser(username, password)){
            repositiry.registerUser(username, password)
            return "Registered successfully"
        }

        return "Login successful"
    }
}