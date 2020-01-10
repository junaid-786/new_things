package com.app.mvvmframework.network

import com.app.mvvmframework.models.GridPostResponseNew
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.HashMap

interface MyApi {

    @POST("user")
   suspend fun imageProfilePost(@Header("HTTP_APPKEY") header: String, @Body hashMap: HashMap<String, String>): Response<GridPostResponseNew>

    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("http://13.232.62.239/clicks/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}