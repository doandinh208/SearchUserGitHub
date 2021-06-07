package com.doan.dinh.doanapplication.di.core

import com.doan.dinh.doanapplication.di.core.module.AppModule
import com.doan.dinh.doanapplication.di.core.module.DataModule
import com.doan.dinh.doanapplication.di.core.module.NetworkModule
import com.doan.dinh.doanapplication.di.search.SearchModule
import com.doan.dinh.doanapplication.di.search.SearchSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    DataModule::class
])

interface CoreComponent {
    fun plus(searchModule: SearchModule): SearchSubComponent
}