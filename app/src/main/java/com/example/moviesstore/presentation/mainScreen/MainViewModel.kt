package com.example.moviesstore.presentation.mainScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesstore.data.files.getData
import com.example.moviesstore.model.Category
import com.example.moviesstore.model.Detail
import com.example.moviesstore.presentation.BaseApplication
import com.example.moviesstore.presentation.mainScreen.components.View
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: BaseApplication,
) : AndroidViewModel(application) {

    var currentView by mutableStateOf(View.MOVIES_CATEGORIES)
    var searchValue by mutableStateOf("")

    var categories = mutableStateListOf<Category>()
    var movieList = mutableStateListOf<Detail>()

    init {
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch {
        categories.addAll(
            getApplication<BaseApplication>().getData(
                "categories.json",
                object : TypeToken<List<Category>>() {}.type
            ) as List<Category>
        )

    }

    fun search() {

    }


    fun onCategoryClicked(id: Int) {

    }
}