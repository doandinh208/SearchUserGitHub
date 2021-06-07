package com.doan.dinh.doanapplication.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.doan.dinh.doanapplication.di.DaggerInjector

abstract class BaseActivity<VM : BaseViewModel>(
) : AppCompatActivity() {

    protected val daggerInjector: DaggerInjector by lazy { application as DaggerInjector }

    protected lateinit var viewModel: VM

    protected abstract fun createViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
    }

    fun <T> LiveData<T>.observe(observer: (T) -> Unit) {
        observe(this@BaseActivity, Observer {
            it?.let { observer(it) }
        })
    }

}