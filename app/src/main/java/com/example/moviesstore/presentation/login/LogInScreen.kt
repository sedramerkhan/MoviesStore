package com.example.moviesstore.presentation.login

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesstore.presentation.destinations.MainScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun LogInScreen(
    navigator: DestinationsNavigator,
    viewModel: LogInViewModel = hiltViewModel()
){

    Button(onClick = { navigator.navigate(MainScreenDestination) }) {
        Text(
            "Click me"
        )
    }
}