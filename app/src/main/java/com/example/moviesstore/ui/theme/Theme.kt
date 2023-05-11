package com.example.moviesstore.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = RedBold,
    onPrimary = Color.White,
    secondary = Color.White,
    onSecondary = RedLight,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = GrayBold,
    onBackground = Color.White,
    surface = GrayLight,
    onSurface = Color.White,
)


@Composable
fun MoviesStoreTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        LightThemeColors
    } else {
        LightThemeColors
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
