package com.example.moviesstore.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesstore.data.repository.LoginRepository
import com.example.moviesstore.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    var user by mutableStateOf<User?>(null)
    var isLoading by mutableStateOf(false)

    init {
        getUserInfo()
    }

    private fun getUserInfo() = viewModelScope.launch {
        loginRepository.getUserInfo().collect {
            user = it
        }
    }

    fun login(user: User) = viewModelScope.launch {
        isLoading = true
        delay(1000)
        loginRepository.login(user)
        isLoading = false
    }

}