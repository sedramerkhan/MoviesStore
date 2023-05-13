package com.example.moviesstore.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesstore.presentation.destinations.LogInScreenDestination
import com.example.moviesstore.presentation.destinations.MainScreenDestination
import com.example.moviesstore.presentation.login.LoginViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import kotlinx.coroutines.delay



@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator,
    viewModel: LoginViewModel = hiltViewModel()
) = viewModel.run {

    val duration = 500
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = duration - 50,
                easing = { OvershootInterpolator(2f).getInterpolation(it) }
            )
        )
        delay(duration.toLong())
        navigator.popBackStack()
        navigator.navigate(if (user == null) LogInScreenDestination else MainScreenDestination)
    }
    Splash(scale.value)
}

@Composable
fun Splash(scale: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize().background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "Movies Store",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.scale(scale),
        )
    }
}