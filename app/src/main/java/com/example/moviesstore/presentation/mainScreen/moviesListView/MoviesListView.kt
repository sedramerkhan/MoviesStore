package com.example.moviesstore.presentation.mainScreen.moviesListView

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviesstore.model.Movie

@Composable
fun MoviesListView(
    modifier: Modifier = Modifier,
    title: String,
    movies: List<Movie>,
    onClick: (Int) -> Unit,
) {
    if (movies.isNotEmpty())
        Column(modifier) {
                Text(
                    title,
                    color = MaterialTheme.colors.onSecondary,
                    style = MaterialTheme.typography.h3
                )

            Spacer(Modifier.height(20.dp))

            MoviesList(movies = movies, onClick = onClick)
        }
    else {
        Box(modifier.fillMaxSize()) {
            Text(
                text = "Coming Soon",
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colors.onSecondary,
                style = MaterialTheme.typography.h3
            )
        }
    }
}