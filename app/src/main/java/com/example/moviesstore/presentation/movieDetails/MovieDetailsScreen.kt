package com.example.moviesstore.presentation.movieDetails

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun MovieDetailsScreen(
    navigator: DestinationsNavigator,
    viewModel: MovieDetailsViewModel = hiltViewModel()
){

}