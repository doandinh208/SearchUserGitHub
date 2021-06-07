package com.doan.dinh.doanapplication.di.core.module

import com.doan.dinh.data.api.GithubService
import com.doan.dinh.data.repository.UserDataSource
import com.doan.dinh.data.repository.UserRemoteDataSource
import com.doan.dinh.data.repository.UserRepositoryImpl
import com.doan.dinh.domain.repository.UserRepository
import com.doan.dinh.domain.usecase.GetDetailUseCase
import com.doan.dinh.domain.usecase.GetSearchUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userRemote: UserDataSource
    ): UserRepository {
        return UserRepositoryImpl(userRemote)
    }

    @Provides
    @Singleton
    fun provideUserDataSource(serviceApi: GithubService): UserDataSource {
        return UserRemoteDataSource(serviceApi)
    }


    @Provides
    fun provideGetSearchUseCase(repository: UserRepository): GetSearchUseCase {
        return GetSearchUseCase(repository)
    }

    @Provides
    fun provideGetDetailUseCase(repository: UserRepository): GetDetailUseCase {
        return GetDetailUseCase(repository)
    }

}