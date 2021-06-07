package com.doan.dinh.data.api

import com.doan.dinh.data.model.ResultEntity
import com.doan.dinh.data.model.UserEntity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/users")
    fun searchUser(@Query("q") query: String): Deferred<ResultEntity>

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Deferred<UserEntity>

}
