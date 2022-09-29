package admiral.group.gamecounter

import admiral.group.gamecounter.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var scoreTeam=0
    var scoreTeam2=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding: ActivityMainBinding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button.setOnClickListener {
            scoreTeam+=1
            binding.textView.text=scoreTeam.toString()
        }

        binding.button2.setOnClickListener {
            scoreTeam2+=1
            binding.textView2.text=scoreTeam2.toString()
        }

        object : CountDownTimer(1000*60, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                binding.textView3.text = "Time\n00:"+(millisUntilFinished / 1000).toString()
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                val bundle = Bundle()

                var winText=""
                binding.textView3.text ="done!"
                if (scoreTeam>scoreTeam2){
                    winText="Barcelona is win!"
                }else if (scoreTeam<scoreTeam2){
                    winText="Raal Madrid is win!"
                }else{
                    winText="Durrang!"
                }
                Toast.makeText(this@MainActivity, winText, Toast.LENGTH_SHORT).show()
                bundle.putString("winnerText", winText)
                intent = Intent(this@MainActivity, WinActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
                finish()

            }
        }.start()

    }
}