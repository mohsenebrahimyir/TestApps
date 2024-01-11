package ir.mohsenebrahimy.mvparchitecturalpattern.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import ir.mohsenebrahimy.mvparchitecturalpattern.databinding.ActivityMainBinding
import ir.mohsenebrahimy.mvparchitecturalpattern.ext.ActivityUtils

class ViewMainActivity : FrameLayout {

    constructor(contextInstance: Context) : super(contextInstance) {

    }

    private lateinit var utils: ActivityUtils
    constructor(contextInstance: Context, utility: ActivityUtils) : super(contextInstance) {
        utils = utility
    }

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun setText(text: String) {
        binding.txtView.text = text
    }

    fun onClick() {
        binding.button.setOnClickListener {
            utils.finished()
        }
    }
}