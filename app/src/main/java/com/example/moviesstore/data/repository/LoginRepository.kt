package com.example.moviesstore.data.repository

import com.example.moviesstore.data.preference.AppDataStore
import com.example.moviesstore.model.User
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val dataStore: AppDataStore
) {
    fun login(user: User){
        dataStore.storeUserData(user)
    }

    fun getUserInfo()= dataStore.userInfo
}