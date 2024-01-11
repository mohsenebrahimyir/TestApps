package ir.mohsenebrahimy.mvparchitecturalpattern.presenter

import ir.mohsenebrahimy.mvparchitecturalpattern.ext.BaseLifecycle
import ir.mohsenebrahimy.mvparchitecturalpattern.model.ModelMainActivity
import ir.mohsenebrahimy.mvparchitecturalpattern.view.ViewMainActivity

class PresenterMainActivity(
    private val view : ViewMainActivity,
    private val model: ModelMainActivity
) : BaseLifecycle {
    override fun onCreate() {
        initData()
    }

    private fun initData() {
        view.setText(model.getText())
    }
}