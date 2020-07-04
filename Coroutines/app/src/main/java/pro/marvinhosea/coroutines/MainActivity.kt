package pro.marvinhosea.coroutines

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLooper = mainLooper
        Log.d("Thread", Thread.currentThread().name)
        GlobalScope.launch {
            Log.d("Thread", Thread.currentThread().name)
            val imageUrl = URL("https://wallpaperplay.com/walls/full/1/c/7/38027.jpg")

            val connection = imageUrl.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()

            val inputStream = connection.inputStream
            val imageBitmap = BitmapFactory.decodeStream(inputStream)

            runOnUiThread {
                Log.d("Thread", Thread.currentThread().name)
                imageView.setImageBitmap(imageBitmap) }
        }
    }
}