package ir.mohsenebrahimy.roomorm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import ir.mohsenebrahimy.roomorm.databinding.ActivityMainBinding
import ir.mohsenebrahimy.roomorm.db.DBHandler
import ir.mohsenebrahimy.roomorm.db.model.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHandler.getDatabase(this)

        binding.button.setOnClickListener {
            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
//                    db.userDao().updateUser(
//                        UserEntity(
//                            id = 1,
//                            name = "Reza",
//                            family = "Ebrahimi",
//                            phone = "09118645816",
//                            age = 25
//                        )
//                    )

//                    db.userDao().deleteUser(
//                        UserEntity(2, "", "", "", 0)
//                    )

                    db.userDao().deleteAllUsers()
                }
            }

            Toast.makeText(this, "Create Use", Toast.LENGTH_SHORT).show()
        }

        binding.button2.setOnClickListener {
            lifecycleScope.launch {
                val users = db.userDao().getUsers
                withContext(Dispatchers.IO) {

                    withContext(Dispatchers.Main) {
                        users.collect { usersList ->
                            var text = ""
                            usersList.forEach {
                                text += "$it\n\n"
                            }

                            binding.textView.text = text
                        }
                    }
                }
            }
        }
    }
}