package com.app.mvvmframework

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

public abstract class BaseActivity <T : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity(){
     lateinit var mViewDataBinding: T

    @LayoutRes
     abstract fun getLayoutId(): Int
     abstract fun getBindingVariable(): Int
     abstract fun getViewModel(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewDataBinding.setVariable(getBindingVariable(), getViewModel())
        mViewDataBinding.executePendingBindings()
    }
    fun getViewDataBinding(): T {
        return mViewDataBinding
    }

}