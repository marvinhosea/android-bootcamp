package pro.marvinhosea.movielist.managers

import androidx.preference.PreferenceManager

class MovieListManager {
    /**
     * Save movie to shared preferences
     */
    fun saveMovieList(){
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences().edit()
        sharedPrefs.putStringSet();
    }
}