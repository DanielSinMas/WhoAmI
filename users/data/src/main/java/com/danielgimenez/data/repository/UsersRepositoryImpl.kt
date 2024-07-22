package com.danielgimenez.data.repository

import com.danielgimenez.data.mapper.toUiModel
import com.danielgimenez.data.remote.RemoteDataSource
import com.danielgimenez.domain.model.UserUiModel
import com.danielgimenez.domain.repository.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): UsersRepository {

    override suspend fun getUsers(): List<UserUiModel> = remoteDataSource.getUsers().toUiModel()
}