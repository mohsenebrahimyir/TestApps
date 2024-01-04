package ir.mohsenebrahimy.retrofitapp

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

    fun sendText(to: String, text: String) {
        RetrofitService.apiService.sendTextToTelegram(to, text).enqueue(
            object : Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                }

            }
        )
    }
}