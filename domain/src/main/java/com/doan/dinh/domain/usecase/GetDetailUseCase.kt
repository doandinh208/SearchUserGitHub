package com.doan.dinh.domain.usecase

import com.doan.dinh.domain.model.UserModel
import com.doan.dinh.domain.repository.UserRepository
import com.doan.dinh.domain.util.Result

open class GetDetailUseCase(private val userRepository: UserRepository) {

    suspend fun execute(id: String): Result<UserModel> {
        return userRepository.getUserDetail(id)
    }

}
