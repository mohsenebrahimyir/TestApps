package ir.mohsenebrahimy.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import ir.mohsenebrahimy.customview.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.lottieSkate.setAnimationFromUrl("https://www.test.com/loading.json")

        binding.seekBar.setOnSeekBarChangeListener (
            object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    binding.lottieLoading.progress = progress.toFloat() / 100
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}

            }
        )

        binding.btnPlay.setOnClickListener {
            binding.lottieLoading.playAnimation()
            binding.lottieLoading.loop(true)
        }

        binding.btnStop.setOnClickListener {
            binding.lottieLoading.loop(false)
            binding.lottieLoading.pauseAnimation()
        }

        loading()

    }

    private var counter = 1

    private fun loading() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.seekBar.progress = counter++
            loading()
        }, 100)
    }
}