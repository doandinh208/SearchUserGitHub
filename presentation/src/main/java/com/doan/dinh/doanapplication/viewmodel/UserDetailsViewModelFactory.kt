
package com.doan.dinh.doanapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doan.dinh.doanapplication.util.DispatchersProvider
import com.doan.dinh.domain.usecase.GetDetailUseCase


class UserDetailsViewModelFactory(

    private val detailUseCase: GetDetailUseCase,
    private val dispatchers: DispatchersProvider
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserDetailsViewModel(detailUseCase, dispatchers) as T
    }
}
