package com.example.moviesstore.presentation.movieDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesstore.data.repository.MainRepository
import com.example.moviesstore.model.Movie
import com.example.moviesstore.presentation.destinations.MovieDetailsScreenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel@Inject constructor(
    private val repo: MainRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
     var movie by mutableStateOf<Movie?>(null)

    private val movieId: Int = MovieDetailsScreenDestination.argsFrom(savedStateHandle).id

    init {
        getMovie()
    }
    fun getMovie() = viewModelScope.launch {
        movie = repo.getMovie(movieId)
    }

    fun addToWatchList(){
        //todo:
    }
}