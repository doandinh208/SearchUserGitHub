package com.doan.dinh.data.repository

import com.doan.dinh.data.api.GithubService
import com.doan.dinh.data.model.SearchEntity
import com.doan.dinh.data.model.UserEntity
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CloudDataStoreTest {

    private lateinit var cloudDataStore: UserRemoteDataSource

    @Mock
    lateinit var mockRestApi: GithubService

    @Before
    fun setUp() {
        cloudDataStore = UserRemoteDataSource(mockRestApi)
    }

    @Test
    fun testGetSearchEntityListFromApi() {
        val searchEntity = mock(SearchEntity::class.java)
        val fakeObservable = CompletableDeferred(searchEntity)
        given(mockRestApi.searchUserAsync("test")).willReturn(fakeObservable)
        runBlockingTest {
            cloudDataStore.searchUser("test")
            verify<GithubService>(mockRestApi).searchUserAsync("test")
        }

    }

    @Test
    fun testGetUserEntityFromApi() {
        val userEntity = mock(UserEntity::class.java)
        val fakeObservable = CompletableDeferred(userEntity)
        given(mockRestApi.getUserAsync("test")).willReturn(fakeObservable)
        runBlockingTest {
            cloudDataStore.getUser("test")
            verify<GithubService>(mockRestApi).getUserAsync("test")
        }
    }

}
