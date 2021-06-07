package com.doan.dinh.domain.usecase


import com.doan.dinh.domain.model.SearchModel
import com.doan.dinh.domain.repository.UserRepository
import com.doan.dinh.domain.util.Result
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetSearchUseCaseTest {

    private lateinit var getSearchUseCase: GetSearchUseCase

    @Mock
    private lateinit var resultMocK: SearchModel

    @Mock
    private lateinit var userRepository: UserRepository

    @get: Rule
    var expectedException: ExpectedException = ExpectedException.none()

    @Before
    fun setUp() {
        getSearchUseCase = GetSearchUseCase(
            userRepository
        )
    }

    @Test
    fun testGetSearchUseCaseObservableHappyCase() {
        runBlocking {
            `when`(userRepository.getSearchUsers("test")).thenReturn(Result.Success(resultMocK))
            getSearchUseCase.execute("test")
            verify(userRepository).getSearchUsers("test")
        }

    }

}
