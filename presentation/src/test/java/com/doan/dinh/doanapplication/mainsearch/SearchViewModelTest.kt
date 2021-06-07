package com.doan.dinh.doanapplication.mainsearch

import androidx.lifecycle.Observer
import com.doan.dinh.doanapplication.base.BaseViewModelTest
import com.doan.dinh.doanapplication.rules.runBlockingTest
import com.doan.dinh.doanapplication.viewmodel.SearchViewModel
import com.doan.dinh.domain.model.SearchModel
import com.doan.dinh.domain.usecase.GetSearchUseCase
import com.doan.dinh.domain.util.Result
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest : BaseViewModelTest() {

    @Mock
    lateinit var searchUserUseCase: GetSearchUseCase

    private lateinit var viewModel: SearchViewModel

    @Before
    fun setUp() {
        viewModel = SearchViewModel(searchUserUseCase, coroutineRule.testDispatcherProvider)
    }

    @Test
    fun searchUser_onSuccess_hideLoadingAndShowResult() {
        coroutineRule.runBlockingTest {

            val resultObs: Observer<SearchModel> = mock()
            val showLoadingObs: Observer<Unit> = mock()
            val hideLoadingObs: Observer<Unit> = mock()

            viewModel.onSearch().observeForever(resultObs)
            viewModel.getShowLoadingLiveData().observeForever(showLoadingObs)
            viewModel.getHideLoadingLiveData().observeForever(hideLoadingObs)

            Mockito.`when`(searchUserUseCase.execute("test")).thenReturn(Result.Success(mock()))

            viewModel.doSearch("test")

            val inOrder = Mockito.inOrder(showLoadingObs, hideLoadingObs, resultObs)

            inOrder.verify(showLoadingObs).onChanged(Unit)
            inOrder.verify(hideLoadingObs).onChanged(Unit)
            inOrder.verify(resultObs).onChanged(any())
        }
    }

    @Test
    fun searchUser_onFailure_hideLoadingAndShowErrorMessage() {
        coroutineRule.runBlockingTest {

            val resultObs: Observer<SearchModel> = mock()
            val errorObs: Observer<String> = mock()
            val showLoadingObs: Observer<Unit> = mock()
            val hideLoadingObs: Observer<Unit> = mock()

            viewModel.onSearch().observeForever(resultObs)
            viewModel.getShowErrorLiveData().observeForever(errorObs)
            viewModel.getShowLoadingLiveData().observeForever(showLoadingObs)
            viewModel.getHideLoadingLiveData().observeForever(hideLoadingObs)

            Mockito.`when`(searchUserUseCase.execute("test")).thenReturn(Result.Error(mock()))

            viewModel.doSearch("test")

            val inOrder = Mockito.inOrder(showLoadingObs, hideLoadingObs, errorObs)

            inOrder.verify(showLoadingObs).onChanged(Unit)
            inOrder.verify(hideLoadingObs).onChanged(Unit)
            inOrder.verify(errorObs).onChanged(any())
            Mockito.verifyZeroInteractions(resultObs)
        }
    }

    @Test
    fun searchUser_onLoading_showLoadingView() {
        coroutineRule.runBlockingTest {

            val showLoadingObs: Observer<Unit> = mock()

            viewModel.getShowLoadingLiveData().observeForever(showLoadingObs)


            viewModel.doSearch("test")

            Mockito.verify(showLoadingObs).onChanged(Unit)
        }
    }


    @Test
    fun onUserClicked_navigateToUserDetails() {
        val navigateObs: Observer<SearchModel.ItemModel> = mock()
        val item: SearchModel.ItemModel = mock()

        viewModel.getNavigateToDetails().observeForever(navigateObs)

        viewModel.onUserItemClick(item)

        Mockito.verify(navigateObs).onChanged(any())
    }

}