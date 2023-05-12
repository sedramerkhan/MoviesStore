package com.example.moviesstore.presentation.login

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun LogInScreen(
    navigator: DestinationsNavigator,
    viewModel: LogInViewModel = hiltViewModel()
){

}