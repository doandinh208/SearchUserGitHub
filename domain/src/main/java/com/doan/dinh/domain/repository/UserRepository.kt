package com.doan.dinh.domain.repository

import com.doan.dinh.domain.util.Result
import com.doan.dinh.domain.model.SearchModel
import com.doan.dinh.domain.model.UserModel

interface UserRepository {
     suspend fun getSearchUsers(query : String): Result<SearchModel>
     suspend fun getUserDetail(id : String): Result<UserModel>
}