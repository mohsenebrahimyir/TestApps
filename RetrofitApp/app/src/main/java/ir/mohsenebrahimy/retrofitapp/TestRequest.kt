package ir.mohsenebrahimy.retrofitapp

import ir.mohsenebrahimy.retrofitapp.model.MainModel

interface TestRequest {

    fun onSuccess(data: MainModel)

    fun onNotSuccess(message: String)

    fun onError(error: String)
}