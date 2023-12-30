package ir.mohsenebrahimy.roomorm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.mohsenebrahimy.roomorm.databinding.ActivityMainBinding
import ir.mohsenebrahimy.roomorm.db.DBHandler

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHandler.getDatabase(this)
    }
}