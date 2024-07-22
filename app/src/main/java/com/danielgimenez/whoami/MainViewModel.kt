package com.danielgimenez.whoami

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielgimenez.domain.model.Response
import com.danielgimenez.domain.model.UserUiModel
import com.danielgimenez.domain.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    private val _users: MutableStateFlow<Response<List<UserUiModel>>> = MutableStateFlow(Response.Loading)
    val users: StateFlow<Response<List<UserUiModel>>> = _users.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = Response.Loading
    )

    fun getUsers() {
        viewModelScope.launch {
            _users.value = getUsersUseCase()
        }
    }
}