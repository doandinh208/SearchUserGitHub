package com.doan.dinh.data.repository

import com.doan.dinh.domain.model.SearchModel
import com.doan.dinh.domain.model.UserModel
import com.doan.dinh.domain.util.Result

interface UserDataSource {
    suspend fun searchUser(query: String): Result<SearchModel>

    suspend fun getUser(username: String): Result<UserModel>

}