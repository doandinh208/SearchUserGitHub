package com.doan.dinh.data.repository

import com.doan.dinh.domain.model.SearchModel
import com.doan.dinh.domain.model.UserModel
import com.doan.dinh.domain.repository.UserRepository
import com.doan.dinh.domain.util.Result

class UserRepositoryImpl constructor(
        private val userRemote: UserDataSource
) : UserRepository {


    override suspend fun getSearchUsers(query: String): Result<SearchModel> {
        return userRemote.searchUser(query)
    }

    override suspend fun getUserDetail(id: String): Result<UserModel> {
        return userRemote.getUser(id)
    }
}