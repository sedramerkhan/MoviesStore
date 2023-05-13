package com.example.moviesstore.presentation.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesstore.data.repository.LoginRepository
import com.example.moviesstore.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    var user by mutableStateOf<User?>(null)

    init {
        getUserInfo()
    }

    private fun getUserInfo() = viewModelScope.launch {
        loginRepository.getUserInfo().collect {
            user = it
        }
    }
}