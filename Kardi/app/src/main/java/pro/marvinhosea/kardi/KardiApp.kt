package pro.marvinhosea.kardi

import android.app.Application

class KardiApp: Application(){
    companion object {
        private lateinit var instance: KardiApp
        fun getAppContext() = instance
    }

    override fun onCreate() {
        super.onCreate()
    }
}