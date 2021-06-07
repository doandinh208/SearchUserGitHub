
package com.doan.dinh.doanapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doan.dinh.doanapplication.util.DispatchersProvider
import com.doan.dinh.domain.usecase.GetSearchUseCase


class SearchViewModelFactory(
    private val searchUseCase: GetSearchUseCase,
    private val dispatchers: DispatchersProvider
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(searchUseCase, dispatchers) as T
    }

}
