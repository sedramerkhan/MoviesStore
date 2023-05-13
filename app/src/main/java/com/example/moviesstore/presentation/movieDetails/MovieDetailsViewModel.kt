package com.example.moviesstore.presentation.movieDetails

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
class MovieDetailsViewModel @Inject constructor(
    private val repo: MainRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    var movie by mutableStateOf<Movie?>(null)

    private val movieId: Int = MovieDetailsScreenDestination.argsFrom(savedStateHandle).id

    var addedToWatchlist by mutableStateOf(false)
    var watchlist = mutableStateListOf<Int>()

    init {
        getMovie()
        checkIfInWatchlist()
        getWatchlist()
    }

    private fun getMovie() = viewModelScope.launch {
        movie = repo.getMovie(movieId)
    }

    fun addToWatchList() = viewModelScope.launch {
        repo.addToWatchlist(movieId)
        Log.i("Hellooo",addedToWatchlist.toString())
        Log.i("Hellooo2",watchlist.toList().toString())
    }

    fun getWatchlist() = viewModelScope.launch {
        repo.getWatchlist().collect {
            it?.let { list ->
                watchlist.addAll(list)
            }
        }
    }
    private fun checkIfInWatchlist() = viewModelScope.launch {
        repo.getWatchlist().collect {
            addedToWatchlist = it?.contains(movieId) ?: false
        }
    }

}