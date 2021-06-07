package com.doan.dinh.doanapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.doan.dinh.doanapplication.base.BaseViewModel
import com.doan.dinh.doanapplication.util.DispatchersProvider
import com.doan.dinh.domain.model.UserModel
import com.doan.dinh.domain.usecase.GetDetailUseCase
import com.doan.dinh.domain.util.Result

class UserDetailsViewModel(
    private val getUserUseCase: GetDetailUseCase,
    dispatchers: DispatchersProvider
) : BaseViewModel(dispatchers) {
    private val detailLiveData: MutableLiveData<UserModel> = MutableLiveData()
    private val showLoadingLiveData: MutableLiveData<Unit> = MutableLiveData()
    private val hideLoadingLiveData: MutableLiveData<Unit> = MutableLiveData()
    private val showErrorLiveData: MutableLiveData<String> = MutableLiveData()


    fun getDetail(username: String) {
        showLoadingLiveData.postValue(Unit)

        execute {
            when (val result = getUserUseCase.execute(username)) {
                is Result.Success -> {
                    hideLoadingLiveData.postValue(Unit)
                    detailLiveData.postValue(result.data)
                }

                is Result.Error -> {
                    hideLoadingLiveData.postValue(Unit)
                    showErrorLiveData.postValue(result.error.message)
                }
            }
        }
    }


    fun onGetDetail(): LiveData<UserModel> = detailLiveData
    fun getShowLoadingLiveData(): LiveData<Unit> = showLoadingLiveData
    fun getHideLoadingLiveData(): LiveData<Unit> = hideLoadingLiveData
    fun getShowErrorLiveData(): LiveData<String> = showErrorLiveData
}
