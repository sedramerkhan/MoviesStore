package com.example.moviesstore.presentation.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesstore.R
import com.example.moviesstore.presentation.destinations.MainScreenDestination
import com.example.moviesstore.presentation.login.components.Texts
import com.example.moviesstore.presentation.login.components.UserInfoFields
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun LogInScreen(
    navigator: DestinationsNavigator,
    viewModel: LoginViewModel = hiltViewModel()
) = viewModel.run {

    Log.i("Hellooo", user.toString())

    if (user != null) {
        navigator.popBackStack()
        navigator.navigate(MainScreenDestination)
    }

    Scaffold(
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val space = 20.dp
            Spacer(modifier = Modifier.height(space))
            Texts()
            Spacer(modifier = Modifier.height(space))
            Image(
                painter = painterResource(id = R.drawable.movie_pop_corn), contentDescription = "",
                modifier = Modifier.weight(1f)
            )

            UserInfoFields(
                isLoading = isLoading,
                login = {
                    Log.i("Hellooooooooo", it.toString())
                    login(it)
                })
            Button(onClick = { navigator.navigate(MainScreenDestination) }) {
                Text(
                    "Click me"
                )
            }
        }
    }
}