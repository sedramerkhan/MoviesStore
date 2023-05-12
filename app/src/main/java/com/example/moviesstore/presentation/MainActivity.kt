package com.example.moviesstore.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.example.moviesstore.ui.theme.MoviesStoreTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesStoreTheme {
                BoxWithConstraints {
                    val width = constraints.maxWidth
                    val height = constraints.maxHeight
                    DestinationsNavHost(
                        navGraph = NavGraphs.root,
                        engine = navHostEngine(IntOffset(width, height))
                    )
                }
            }
        }
    }
}


//https://github.com/raamcosta/compose-destinations/issues/41
@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
val navHostEngine = @Composable { offset: IntOffset ->
    rememberAnimatedNavHostEngine(
        rootDefaultAnimations = RootNavGraphDefaultAnimations(
            enterTransition = {
                slideIn(
                    initialOffset = { offset },
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = FastOutSlowInEasing
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 1500, //it's bigger than slideIn duration to not show black background
                        easing = FastOutSlowInEasing
                    )
                )
            },
            popEnterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = FastOutSlowInEasing
                    )
                )
            },
            popExitTransition = {
                slideOut(
                    targetOffset = { offset },
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = FastOutSlowInEasing
                    )
                )
            }
        ),
    )
}
