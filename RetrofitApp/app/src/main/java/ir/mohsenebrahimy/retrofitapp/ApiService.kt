package ir.mohsenebrahimy.retrofitapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("send")
    fun sendTextToTelegram(
        @Query("to") token: String,
        @Query("text") message: String
    ) : Call<String>
}