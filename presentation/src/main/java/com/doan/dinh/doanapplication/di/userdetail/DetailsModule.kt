package com.doan.dinh.doanapplication.di.userdetail

import com.doan.dinh.doanapplication.util.DispatchersProvider
import com.doan.dinh.doanapplication.viewmodel.UserDetailsViewModelFactory
import com.doan.dinh.domain.usecase.GetDetailUseCase
import dagger.Module
import dagger.Provides
@Module
class DetailsModule {

    @Provides
    fun provideUserDetailsViewModelFactory(useCase : GetDetailUseCase, dispatchersProvider: DispatchersProvider): UserDetailsViewModelFactory {
        return UserDetailsViewModelFactory(useCase, dispatchersProvider)
    }
}