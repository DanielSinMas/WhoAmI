package com.danielgimenez.data.di

import com.danielgimenez.data.remote.RemoteDataSource
import com.danielgimenez.data.remote.RemoteDataSourceImpl
import com.danielgimenez.data.repository.UsersRepositoryImpl
import com.danielgimenez.domain.repository.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsUsersRepository(impl: UsersRepositoryImpl): UsersRepository

    @Binds
    abstract fun bindsRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
}