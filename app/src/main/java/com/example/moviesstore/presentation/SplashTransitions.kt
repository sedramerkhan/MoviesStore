package com.example.moviesstore.presentation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import com.example.moviesstore.presentation.destinations.LogInScreenDestination
import com.example.moviesstore.presentation.destinations.SplashScreenDestination

import com.ramcosta.composedestinations.spec.DestinationStyle

@OptIn(ExperimentalAnimationApi::class)
object SplashTransitions : DestinationStyle.Animated {

    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {

        return when (initialState.appDestination()) {
            SplashScreenDestination ->
                fadeIn(animationSpec = tween(300)) + expandVertically(tween(300))
            else -> null
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.exitTransition(): ExitTransition? {

        return when (targetState.appDestination()) {
            SplashScreenDestination ->
                fadeOut(animationSpec = tween(300)) + shrinkOut(tween(300))
            else -> null
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popEnterTransition(): EnterTransition? {

        return when (initialState.appDestination()) {
            SplashScreenDestination -> fadeIn(animationSpec = tween(800))
            else -> null
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popExitTransition(): ExitTransition? {

        return when (targetState.appDestination()) {
            SplashScreenDestination -> fadeOut(animationSpec = tween(300))
            else -> null
        }
    }
}