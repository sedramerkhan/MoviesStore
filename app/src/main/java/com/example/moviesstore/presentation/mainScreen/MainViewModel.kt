package com.example.moviesstore.presentation.mainScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesstore.data.repository.MainRepository
import com.example.moviesstore.model.Category
import com.example.moviesstore.model.Movie
import com.example.moviesstore.presentation.mainScreen.components.View
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: MainRepository
) : ViewModel() {

    var currentView by mutableStateOf(View.MOVIES_CATEGORIES)
    var searchValue by mutableStateOf("")

    var categories = mutableStateListOf<Category>()
    var movieList = mutableStateListOf<Movie>()
    var movieListCategory = mutableStateListOf<Movie>()

    var chosenCategory by mutableStateOf<Category?>(null)

    var loadingState by mutableStateOf(true)
    init {
        getCategories()
        getMoviesList()
    }

    private fun getCategories() = viewModelScope.launch {
        delay(2000)
        categories.addAll(repo.getCategories())
        loadingState = false
    }

    private fun getMoviesList() = viewModelScope.launch {
        movieList.addAll(repo.getMoviesList())
    }

    fun onCategoryClicked(category: Category) {
        chosenCategory = category
        currentView = View.MOVIES_LIST
        movieListCategory.clear()
        movieListCategory.addAll(movieList.filter { it.category_id == category.id })
    }

    fun search() {

    }


}