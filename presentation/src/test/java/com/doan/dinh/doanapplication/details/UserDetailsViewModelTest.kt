package com.doan.dinh.doanapplication.details

import androidx.lifecycle.Observer
import com.doan.dinh.doanapplication.base.BaseViewModelTest
import com.doan.dinh.doanapplication.rules.runBlockingTest
import com.doan.dinh.doanapplication.viewmodel.UserDetailsViewModel
import com.doan.dinh.domain.model.UserModel
import com.doan.dinh.domain.usecase.GetDetailUseCase
import com.doan.dinh.domain.util.Result
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserDetailsViewModelTest : BaseViewModelTest() {

    @Mock
    lateinit var userDetail: UserModel

    @Mock
    lateinit var getDetailUseCase: GetDetailUseCase

    private lateinit var viewModel: UserDetailsViewModel

    @Before
    fun setUp() {
        viewModel = UserDetailsViewModel(getDetailUseCase, coroutineRule.testDispatcherProvider)
    }

    @Test
    fun getDetail_onSuccess_hideLoadingAndShowResult() {
        coroutineRule.runBlockingTest {

            val resultObs: Observer<UserModel> = mock()
            val showLoadingObs: Observer<Unit> = mock()
            val hideLoadingObs: Observer<Unit> = mock()

            viewModel.onGetDetail().observeForever(resultObs)
            viewModel.getShowLoadingLiveData().observeForever(showLoadingObs)
            viewModel.getHideLoadingLiveData().observeForever(hideLoadingObs)

            Mockito.`when`(getDetailUseCase.execute("test")).thenReturn(Result.Success(mock()))

            viewModel.getDetail("test")

            val inOrder = Mockito.inOrder(showLoadingObs, hideLoadingObs, resultObs)

            inOrder.verify(showLoadingObs).onChanged(Unit)
            inOrder.verify(hideLoadingObs).onChanged(Unit)
            inOrder.verify(resultObs).onChanged(any())
        }
    }

    @Test
    fun getDetail_onFailure_hideLoadingAndShowErrorMessage() {
        coroutineRule.runBlockingTest {

            val resultObs: Observer<UserModel> = mock()
            val errorObs: Observer<String> = mock()
            val showLoadingObs: Observer<Unit> = mock()
            val hideLoadingObs: Observer<Unit> = mock()

            viewModel.onGetDetail().observeForever(resultObs)
            viewModel.getShowErrorLiveData().observeForever(errorObs)
            viewModel.getShowLoadingLiveData().observeForever(showLoadingObs)
            viewModel.getHideLoadingLiveData().observeForever(hideLoadingObs)

            Mockito.`when`(getDetailUseCase.execute("test")).thenReturn(Result.Error(mock()))

            viewModel.getDetail("test")

            val inOrder = Mockito.inOrder(showLoadingObs, hideLoadingObs, errorObs)

            inOrder.verify(showLoadingObs).onChanged(Unit)
            inOrder.verify(hideLoadingObs).onChanged(Unit)
            inOrder.verify(errorObs).onChanged(any())
            Mockito.verifyZeroInteractions(resultObs)
        }
    }

    @Test
    fun getDetail_onLoading_showLoadingView() {
        coroutineRule.runBlockingTest {

            val showLoadingObs: Observer<Unit> = mock()

            viewModel.getShowLoadingLiveData().observeForever(showLoadingObs)


            viewModel.getDetail("test")

            Mockito.verify(showLoadingObs).onChanged(Unit)
        }
    }


}