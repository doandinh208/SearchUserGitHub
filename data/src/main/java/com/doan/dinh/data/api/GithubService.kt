package com.doan.dinh.data.api

import com.doan.dinh.data.model.ResultEntity
import com.doan.dinh.data.model.UserEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/users")
    suspend fun searchUser(@Query("q") query: String): ResultEntity

    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): UserEntity

}
