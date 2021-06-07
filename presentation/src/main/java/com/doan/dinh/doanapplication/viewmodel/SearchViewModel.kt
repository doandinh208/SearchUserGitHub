
package com.doan.dinh.doanapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.doan.dinh.doanapplication.base.BaseViewModel
import com.doan.dinh.doanapplication.util.DispatchersProvider
import com.doan.dinh.domain.model.SearchModel
import com.doan.dinh.domain.usecase.GetSearchUseCase
import com.doan.dinh.domain.util.Result

class SearchViewModel(
    private val searchUseCase: GetSearchUseCase,
    dispatchers: DispatchersProvider
) : BaseViewModel(dispatchers) {

    private val searchLiveData: MutableLiveData<SearchModel> = MutableLiveData()
    private val showLoadingLiveData: MutableLiveData<Unit> = MutableLiveData()
    private val hideLoadingLiveData: MutableLiveData<Unit> = MutableLiveData()
    private val showErrorLiveData: MutableLiveData<String> = MutableLiveData()
    private val navigateToDetail: MutableLiveData<SearchModel.ItemModel> = MutableLiveData()


    fun doSearch(key : String) {
        showLoadingLiveData.postValue(Unit)

        execute {
            when (val result = searchUseCase.execute(key)) {
                is Result.Success -> {
                    hideLoadingLiveData.postValue(Unit)
                    searchLiveData.postValue(result.data)
                }

                is Result.Error -> {
                    hideLoadingLiveData.postValue(Unit)
                    showErrorLiveData.postValue(result.error.message)
                }
            }
        }
    }

    fun onUserItemClick(user: SearchModel.ItemModel) {
        navigateToDetail.postValue(user)
    }

    fun onSearch(): LiveData<SearchModel> = searchLiveData
    fun getShowLoadingLiveData(): LiveData<Unit> = showLoadingLiveData
    fun getHideLoadingLiveData(): LiveData<Unit> = hideLoadingLiveData
    fun getShowErrorLiveData(): LiveData<String> = showErrorLiveData
    fun getNavigateToDetails(): LiveData<SearchModel.ItemModel> = navigateToDetail

}
