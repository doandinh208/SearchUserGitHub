
package com.doan.dinh.doanapplication.viewmodel

import com.doan.dinh.doanapplication.base.BaseViewModel
import com.doan.dinh.doanapplication.util.DispatchersProvider
import com.doan.dinh.domain.usecase.GetSearchUseCase


class SearchViewModel(
    private val searchUseCase: GetSearchUseCase,
    dispatchers: DispatchersProvider
) : BaseViewModel(dispatchers) {

    companion object {
        private const val TAG = "SearchViewModel"
    }

}
