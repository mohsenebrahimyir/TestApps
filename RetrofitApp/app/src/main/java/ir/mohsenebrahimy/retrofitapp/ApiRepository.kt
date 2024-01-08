package ir.mohsenebrahimy.retrofitapp

import ir.mohsenebrahimy.retrofitapp.model.MainModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository private constructor(){
    companion object {
        private var apiRepository: ApiRepository? = null

        val instant: ApiRepository
            get() {
                if (apiRepository == null) apiRepository = ApiRepository()
                return apiRepository!!
            }
        fun getInstance(): ApiRepository{
            if (apiRepository == null) apiRepository = ApiRepository()
            return apiRepository!!
        }
    }

    fun sendText(
        to: String,
        text: String,
        request: TestRequest
    ) {
        RetrofitService.apiService.sendTextToTelegram(to, text).enqueue(
            object : Callback<MainModel>{
                override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
                    if (response.isSuccessful) {
                        val data = response.body() as MainModel
                        request.onSuccess(data)
                    } else {
                        request.onNotSuccess("Not Success")
                    }
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    request.onError("Error: ${t.message}")
                }

            }
        )
    }
}