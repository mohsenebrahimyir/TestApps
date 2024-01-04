package ir.mohsenebrahimy.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import ir.mohsenebrahimy.test_app.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val name = intent.getStringExtra("name")
        val id = intent.getIntExtra("id", 0)
        val sleep = intent.getBooleanExtra("sleep", false)

        binding.btnExit.setOnClickListener {
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        }


        binding.btnExit.setOnLongClickListener {
            Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()

            Log.i("LONG_CLICK", sleep.toString())

            return@setOnLongClickListener true
        }
    }
}
