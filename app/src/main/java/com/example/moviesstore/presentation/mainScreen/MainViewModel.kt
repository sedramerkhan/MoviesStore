package com.example.moviesstore.presentation.mainScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.moviesstore.presentation.mainScreen.components.View

class MainViewModel: ViewModel() {

    var currentView by mutableStateOf(View.MOVIES_CATEGORIES)
    var searchValue by mutableStateOf("")

    fun search(){

    }
}