package admiral.group.gamecounter

import admiral.group.gamecounter.databinding.ActivityMainBinding
import admiral.group.gamecounter.databinding.ActivityWinBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

class WinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        supportActionBar?.hide()
        val binding: ActivityWinBinding = DataBindingUtil.setContentView(this, R.layout.activity_win)

        val bundle = intent.extras

        var s:String? = null

        s = bundle!!.getString("winnerText", "Default")

        binding.txtWinner.text=s

    }
}