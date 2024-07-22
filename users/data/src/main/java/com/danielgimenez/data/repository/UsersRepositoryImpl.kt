package com.danielgimenez.data.repository

import com.danielgimenez.data.mapper.toUiModel
import com.danielgimenez.data.remote.RemoteDataSource
import com.danielgimenez.domain.model.Response
import com.danielgimenez.domain.model.UserUiModel
import com.danielgimenez.domain.repository.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): UsersRepository {

    override suspend fun getUsers(): Response<List<UserUiModel>> {
        try {
            return Response.Success(remoteDataSource.getUsers().toUiModel())
        } catch (e: Exception) {
            return Response.Error(e.message?: "Unexpected error")
        }
    }
}