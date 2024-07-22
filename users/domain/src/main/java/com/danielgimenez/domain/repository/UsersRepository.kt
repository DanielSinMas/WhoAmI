package com.danielgimenez.domain.repository

import com.danielgimenez.domain.model.UserUiModel

interface UsersRepository {

    suspend fun getUsers(): List<UserUiModel>
}