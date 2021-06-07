package com.doan.dinh.data.repository

import com.doan.dinh.data.api.GithubService
import com.doan.dinh.data.mapper.SearchResultMapper
import com.doan.dinh.data.mapper.UserMapper
import com.doan.dinh.domain.model.SearchModel
import com.doan.dinh.domain.model.UserModel
import java.lang.Exception
import com.doan.dinh.domain.util.Result
class UserRemoteDataSource(private val serviceApi: GithubService) : UserDataSource {


    override suspend fun searchUser(query: String): Result<SearchModel> {
        return try {
            val result = serviceApi.searchUser(query).await()
            Result.Success(SearchResultMapper.toDomain(result))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getUser(username: String): Result<UserModel> {
        return try {
            val result = serviceApi.getUser(username).await()
            Result.Success(UserMapper.toDomain(result))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}