package com.danielgimenez.data.remote

import com.danielgimenez.data.model.GetUsersModel
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {

    @GET("api")
    suspend fun getUsers(
        @Query("results") results: Int,
        @Query("nat") nat: String
    ): GetUsersModel
}