package ir.mohsenebrahimy.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import io.github.cdimascio.dotenv.dotenv
import ir.mohsenebrahimy.retrofitapp.databinding.ActivityMainBinding
import ir.mohsenebrahimy.retrofitapp.model.MainModel

class MainActivity : AppCompatActivity(), TestRequest  {

    private var dotenv = dotenv {
        directory = "./assets"
        filename = "env"
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            binding.progressBar.visibility = View.VISIBLE
            ApiRepository.instant.sendText(
                dotenv["NOTIFICATOR_TOKEN"],
                "Salam Mohsen",
                this
            )
        }

        val url = "https://www.mohsenebrahimy.ir/wp-content/uploads/2019/11/negaresh-1.jpg"

//        Picasso.get()
//            .load(url)
//            .placeholder(R.drawable.ic_launcher_background)
//            .error(R.drawable.ic_launcher_foreground)
//            .fit()
//            .into(binding.imageView)

        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .into(binding.imageView)
    }

    override fun onSuccess(data: MainModel) {
        binding.progressBar.visibility = View.INVISIBLE
        binding.txtTest.text = data.message
    }

    override fun onNotSuccess(message: String) {
        binding.txtTest.text = message
    }

    override fun onError(error: String) {
        Log.i("ERROR_HANDLER", error)
    }
}