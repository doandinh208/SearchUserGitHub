package com.doan.dinh.doanapplication.di.search

import com.doan.dinh.doanapplication.view.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [SearchModule::class])
interface SearchSubComponent {
    fun inject(mainActivity: MainActivity)
}