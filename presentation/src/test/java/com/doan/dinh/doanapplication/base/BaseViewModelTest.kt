package com.doan.dinh.doanapplication.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.doan.dinh.doanapplication.rules.CoroutineTestRule
import org.junit.Rule
import org.mockito.Mockito


open class BaseViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineRule = CoroutineTestRule()

    /**
     * Returns Mockito.any() as nullable type to avoid java.lang.IllegalStateException when
     * null is returned.
     */
    fun <T> any(): T = Mockito.any()

    /**
     * Gives you the ability to mock observes programmatically
     * **/
    inline fun <reified T> mock(): T = Mockito.mock(T::class.java)
}