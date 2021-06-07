
package com.doan.dinh.doanapplication.viewmodel

import androidx.lifecycle.*
import com.doan.dinh.doanapplication.base.BaseViewModel
import com.doan.dinh.doanapplication.util.DispatchersProvider
import com.doan.dinh.domain.usecase.GetDetailUseCase


class UserDetailsViewModel(
    private  val getUserUseCase: GetDetailUseCase,
    dispatchers: DispatchersProvider
) : BaseViewModel(dispatchers) {

}
