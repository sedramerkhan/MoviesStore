package com.example.moviesstore.presentation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import com.example.moviesstore.presentation.appDestination
import com.example.moviesstore.presentation.destinations.LogInScreenDestination

import com.ramcosta.composedestinations.spec.DestinationStyle

@OptIn(ExperimentalAnimationApi::class)
object LogInTransitions : DestinationStyle.Animated {

    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {

        return when (initialState.appDestination()) {
            LogInScreenDestination ->
                fadeIn(animationSpec = tween(500)) + expandVertically(tween(500))
            else -> null
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.exitTransition(): ExitTransition? {

        return when (targetState.appDestination()) {
            LogInScreenDestination ->
                fadeOut(animationSpec = tween(500)) + shrinkOut(tween(500))
            else -> null
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popEnterTransition(): EnterTransition? {

        return when (initialState.appDestination()) {
            LogInScreenDestination -> fadeIn(animationSpec = tween(500))
            else -> null
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popExitTransition(): ExitTransition? {

        return when (targetState.appDestination()) {
            LogInScreenDestination -> fadeOut(animationSpec = tween(500))
            else -> null
        }
    }
}