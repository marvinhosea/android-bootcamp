package pro.marvinhosea.doo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            delay(3000)
            Handler(Looper.getMainLooper()).post{
                Toast.makeText(this@SplashScreenActivity, "We made a splash screen", Toast.LENGTH_SHORT).show()
            }
        }
    }
}