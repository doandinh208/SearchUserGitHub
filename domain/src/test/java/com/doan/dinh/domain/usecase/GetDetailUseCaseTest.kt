package com.doan.dinh.domain.usecase


import com.doan.dinh.domain.model.UserModel
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
class GetDetailUseCaseTest {

    private lateinit var getDetailUseCase: GetDetailUseCase

    @Mock
    private lateinit var resultMocK: UserModel

    @Mock
    private lateinit var userRepository: UserRepository

    @get: Rule
    var expectedException: ExpectedException = ExpectedException.none()

    @Before
    fun setUp() {
        getDetailUseCase = GetDetailUseCase(
            userRepository
        )
    }

    @Test
    fun testGetSearchUseCaseObservableHappyCase() {
        runBlocking {
            `when`(userRepository.getUserDetail("test")).thenReturn(Result.Success(resultMocK))
            getDetailUseCase.execute("test")
            verify(userRepository).getUserDetail("test")
        }

    }

}
