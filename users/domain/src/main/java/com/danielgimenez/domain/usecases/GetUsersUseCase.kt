package com.danielgimenez.domain.usecases

import com.danielgimenez.domain.model.Response
import com.danielgimenez.domain.model.UserUiModel

interface GetUsersUseCase {
    suspend operator fun invoke(): Response<List<UserUiModel>>
}