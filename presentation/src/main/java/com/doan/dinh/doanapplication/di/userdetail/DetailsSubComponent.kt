package com.doan.dinh.doanapplication.di.userdetail

import com.doan.dinh.doanapplication.di.userdetail.DetailsModule
import com.doan.dinh.doanapplication.view.UserDetailsActivity
import dagger.Subcomponent

@Subcomponent(modules = [DetailsModule::class])
interface DetailsSubComponent {
    fun inject(movieDetailsActivity: UserDetailsActivity)
}