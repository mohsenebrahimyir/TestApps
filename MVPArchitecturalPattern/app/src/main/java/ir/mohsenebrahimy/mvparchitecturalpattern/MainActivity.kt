package ir.mohsenebrahimy.mvparchitecturalpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.mohsenebrahimy.mvparchitecturalpattern.model.ModelMainActivity
import ir.mohsenebrahimy.mvparchitecturalpattern.presenter.PresenterMainActivity
import ir.mohsenebrahimy.mvparchitecturalpattern.view.ViewMainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: PresenterMainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ViewMainActivity(this)
        setContentView(view.binding.root)

        val model = ModelMainActivity()
        presenter = PresenterMainActivity(view, model)

        presenter.onCreate()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}