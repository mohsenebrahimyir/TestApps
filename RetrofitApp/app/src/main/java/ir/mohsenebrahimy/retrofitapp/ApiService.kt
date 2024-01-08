package ir.mohsenebrahimy.retrofitapp


import ir.mohsenebrahimy.retrofitapp.model.MainModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // https://domin.com/api/time
    @GET("time")
    fun sendText() : Call<MainModel>

    // https://domin.com/api/senc
    @GET("send")
    fun sendTextToTelegram(
        @Query("to") token: String,
        @Query("text") message: String
    ) : Call<MainModel>

    // https://domin.com/api/user/8
    @GET("user/{id}")
    fun sendTest(
        @Path(value = "id", encoded = false) ID: Int,
        @Query("to") token: String,
        @Query("text") message: String
    ) : Call<MainModel>

    // https://domin.com/api/user
    @GET("user")
    fun sendTest2(
        @Header("app-api-key") apiKey: String,
        @Query("to") token: String,
        @Query("text") message: String
    ) : Call<MainModel>

    // https://domin.com/api/user/address
    @FormUrlEncoded
    @POST("user/address")
    fun sendTest3(
        @Header("app-api-key") apiKey: String,
        @Field("address") address: String,
        @Field("receiver") receiver: String
    ) : Call<MainModel>

    // https://domin.com/api/user/address/{id}
    @FormUrlEncoded
    @POST("user/address/{id}")
    fun editAddress(
        @Header("app-device-uid") id: String,
        @Header("app-public-key") pubKey: String,
        @Header("app-api-key") apiKey: String,
        @Field("address") address: String,
        @Field("receiver") receiver: String,
        @Field("phone") phone: String,
        @Path(value = "id", encoded = false) ID: String
    ) : Call<MainModel>
}