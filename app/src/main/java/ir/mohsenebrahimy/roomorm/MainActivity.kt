package ir.mohsenebrahimy.roomorm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ir.mohsenebrahimy.roomorm.databinding.ActivityMainBinding
import ir.mohsenebrahimy.roomorm.db.DBHandler
import ir.mohsenebrahimy.roomorm.db.model.UserEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHandler.getDatabase(this)

        binding.button.setOnClickListener{
            Thread{
                db.userDao().insertUser(
                    UserEntity(
                        name = "Mohsen",
                        family = "Ebrahimi",
                        phone = "09118645816",
                        age = 25
                    )
                )
            }.start()

            Toast.makeText(this, "Create Use", Toast.LENGTH_SHORT).show()
        }
    }
}