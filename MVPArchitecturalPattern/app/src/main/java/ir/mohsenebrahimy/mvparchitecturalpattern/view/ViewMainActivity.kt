package ir.mohsenebrahimy.mvparchitecturalpattern.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import ir.mohsenebrahimy.mvparchitecturalpattern.databinding.ActivityMainBinding

class ViewMainActivity(
    contextInstance: Context
) : FrameLayout(contextInstance) {
    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun setText(text: String) {
        binding.txtView.text = text
    }
}