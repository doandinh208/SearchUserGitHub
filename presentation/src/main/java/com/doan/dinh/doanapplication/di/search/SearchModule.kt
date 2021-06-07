package com.doan.dinh.doanapplication.di.search

import com.doan.dinh.doanapplication.util.DispatchersProvider
import com.doan.dinh.doanapplication.viewmodel.SearchViewModelFactory
import com.doan.dinh.domain.usecase.GetSearchUseCase
import dagger.Module
import dagger.Provides

@Module
class SearchModule {

    @Provides
    fun provideSearchViewModelFactory(useCase: GetSearchUseCase, dispatchersProvider: DispatchersProvider): SearchViewModelFactory {
        return SearchViewModelFactory(useCase, dispatchersProvider)
    }

}