package com.danielgimenez.data.remote

import com.danielgimenez.data.model.GetUsersModel

interface RemoteDataSource {

    suspend fun getUsers(): GetUsersModel
}