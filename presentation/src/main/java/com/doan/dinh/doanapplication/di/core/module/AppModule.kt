package com.doan.dinh.doanapplication.di.core.module

import android.content.Context
import com.doan.dinh.doanapplication.util.DispatchersProvider
import com.doan.dinh.doanapplication.util.DispatchersProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(context: Context) {

    private val appContext = context.applicationContext

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return appContext
    }

    @Provides
    fun provideDispatchersProvider(): DispatchersProvider {
        return DispatchersProviderImpl()
    }

}