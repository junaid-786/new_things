package com.app.mvvmframework

import androidx.lifecycle.MutableLiveData
import com.app.mvvmframework.coroutines.Coroutines
import com.app.mvvmframework.models.GridPostResponseNew
import com.app.mvvmframework.network.ApiExceptions
import com.app.mvvmframework.repositories.UserRepository
import java.util.*

class MainViewModel: BaseViewModelNew<MainNavigation>() {
   // var email: MutableLiveData<String> = MutableLiveData<String>()
    var email=""
    var list:MutableList<GridPostResponseNew.Result> = mutableListOf()


    init {

    }
    public fun onClickText(){
        getNavigator().onLoginScreen()
    }
    fun callApi(email:String){

        var e=email
        var s="sdhfjkh"

        /**
         * Call api
         */

        Coroutines.main{
            try {
                var user_id="996"
                var accessToken="6def11595e96af51c21daa666459cf6c"
                var hashMap = HashMap<String, String>()
                hashMap.put("method", "myprofile_posts")
                hashMap.put("user_id", user_id)
                hashMap.put("view_type", "1")//view type=1 means images
                val response=UserRepository().gridPostResponse(accessToken!!,hashMap!!)
                var co=response.APPICODERESULT
                list.addAll(response.result)
                var s="fjkl"

            }catch (e:ApiExceptions){

            }

        }
        //end
    }





}