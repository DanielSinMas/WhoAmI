package com.danielgimenez.domain.repository

import com.danielgimenez.domain.model.Response
import com.danielgimenez.domain.model.UserUiModel

interface UsersRepository {

    suspend fun getUsers(): Response<List<UserUiModel>>
}