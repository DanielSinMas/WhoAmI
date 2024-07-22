package com.danielgimenez.domain.di

import com.danielgimenez.domain.usecases.GetUsersUseCase
import com.danielgimenez.domain.usecases.GetUsersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsGetUsersUseCase(impl: GetUsersUseCaseImpl): GetUsersUseCase
}