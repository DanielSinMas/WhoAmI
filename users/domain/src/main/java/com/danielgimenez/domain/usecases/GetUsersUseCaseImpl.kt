package com.danielgimenez.domain.usecases

import com.danielgimenez.domain.model.Response
import com.danielgimenez.domain.model.UserUiModel
import com.danielgimenez.domain.repository.UsersRepository
import javax.inject.Inject

class GetUsersUseCaseImpl @Inject constructor(
    private val repository: UsersRepository
): GetUsersUseCase {

    override suspend fun invoke(): Response<List<UserUiModel>> = repository.getUsers()
}