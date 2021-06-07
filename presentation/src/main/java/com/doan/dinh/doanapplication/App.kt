package com.doan.dinh.doanapplication

import android.app.Application
import com.doan.dinh.doanapplication.di.DaggerInjector
import com.doan.dinh.doanapplication.di.core.CoreComponent
import com.doan.dinh.doanapplication.di.core.DaggerCoreComponent
import com.doan.dinh.doanapplication.di.core.module.AppModule
import com.doan.dinh.doanapplication.di.core.module.DataModule
import com.doan.dinh.doanapplication.di.core.module.NetworkModule
import com.doan.dinh.doanapplication.di.search.SearchModule
import com.doan.dinh.doanapplication.di.search.SearchSubComponent

class App : Application(), DaggerInjector {

    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.builder()
                .appModule(AppModule(applicationContext))
                .networkModule(NetworkModule(BuildConfig.BASE_URL))
                .dataModule(DataModule())
                .build()
    }


    override fun createSearchComponent(): SearchSubComponent {
        return coreComponent.plus(SearchModule())
    }
}