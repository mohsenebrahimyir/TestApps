package ir.mohsenebrahimy.mvparchitecturalpattern.ext

interface BaseLifecycle {

    fun onCreate()

    fun onStart(){}

    fun onStop(){}

    fun onRestart(){}

    fun onDestroy(){}
}