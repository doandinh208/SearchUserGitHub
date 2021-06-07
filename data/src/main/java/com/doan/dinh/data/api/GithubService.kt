package com.doan.dinh.data.api

import com.doan.dinh.data.model.SearchEntity
import com.doan.dinh.data.model.UserEntity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/users")
    fun searchUserAsync(@Query("q") query: String): Deferred<SearchEntity>

    @GET("users/{username}")
    fun getUserAsync(@Path("username") username: String): Deferred<UserEntity>

}
