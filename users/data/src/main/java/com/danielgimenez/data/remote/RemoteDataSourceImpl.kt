package com.danielgimenez.data.remote

import com.danielgimenez.data.model.GetUsersModel
import com.danielgimenez.data.model.Info
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: UsersService
): RemoteDataSource {

    override suspend fun getUsers(): GetUsersModel = service.getUsers(10, "es")
}