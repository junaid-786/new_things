package com.app.mvvmframework

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.app.mvvmframework.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(),MainNavigation {
    lateinit var mainViewModel: MainViewModel
     lateinit var binding: ActivityMainBinding

    override fun getLayoutId() = R.layout.activity_main


    override fun getBindingVariable() = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=getViewDataBinding()
        binding.viewModel=mainViewModel
        binding.lifecycleOwner = this
        mainViewModel.setNavigator(this)

    }
    override fun getViewModel(): MainViewModel {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        return mainViewModel
    }

    override fun onLoginScreen() {
         //var intent=Intent(this,LoginScreenActivity::class.java)
        // startActivity(intent)
       // mainViewModel.callApi()
    }

    override fun onHomeScreen() {

    }


}


