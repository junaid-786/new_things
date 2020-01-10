package com.app.mvvmframework.network

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class SafeApiRequest{
    suspend fun <T: Any> apiRequest(call: suspend ()-> Response<T>): T {
        val resposne=call.invoke()
        val message=StringBuilder()
        if (resposne.isSuccessful){
            return resposne.body()!!
        }else{
            val error = resposne.errorBody()?.string()

            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))

                }catch (e : JSONException){
                  message.append("\n")
                }
                message.append("Error Code: ${resposne.code()}")
                throw ApiExceptions(message.toString())
            }
        }
        throw ApiExceptions(message.toString())

    }
}