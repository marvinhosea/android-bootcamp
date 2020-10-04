package pro.marvinhosea.kardi.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.fragment_home.*
import pro.marvinhosea.kardi.R
import pro.marvinhosea.kardi.ui.game.GameActivity

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeButton.setOnClickListener {
            FancyToast.makeText(activity, "Opened game", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show()
            val intent = Intent(activity, GameActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
}