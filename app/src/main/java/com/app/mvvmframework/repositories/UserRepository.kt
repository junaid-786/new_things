package com.app.mvvmframework.repositories
import com.app.mvvmframework.models.GridPostResponseNew
import com.app.mvvmframework.network.MyApi
import com.app.mvvmframework.network.SafeApiRequest
import java.util.*

class UserRepository : SafeApiRequest(){
    suspend fun gridPostResponse(header: String,hashMap: HashMap<String, String>):GridPostResponseNew{
         return apiRequest { MyApi().imageProfilePost(header,hashMap) }
    }

}