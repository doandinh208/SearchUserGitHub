package com.doan.dinh.domain.usecase

import com.doan.dinh.domain.model.SearchModel
import com.doan.dinh.domain.repository.UserRepository
import com.doan.dinh.domain.util.Result

open class GetSearchUseCase(private val user: UserRepository) {

    suspend fun execute(query: String): Result<SearchModel> {
        return user.getSearchUsers(query)
    }

}
