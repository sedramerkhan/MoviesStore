package com.example.moviesstore.presentation.movieDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.moviesstore.model.Movie
import com.example.moviesstore.ui.theme.GrayVeryLight

@Composable
fun SummaryDirectiveWriters(
    movie: Movie,
    space: Dp,
) {
    Column() {
        Text(
            text = "Summary",
            style = MaterialTheme.typography.h4
        )
        Spacer(Modifier.height(space))
        Text(
            text = movie.summary,
            style = MaterialTheme.typography.body2
        )
        Spacer(Modifier.height(space))
        Row() {
            Text(
                text = "Directive: ",
                style = MaterialTheme.typography.subtitle2,
                color = GrayVeryLight
            )

            Text(
                text = movie.director,
                style = MaterialTheme.typography.body2,
                color = GrayVeryLight
            )
        }
        Spacer(Modifier.height(space))
        Row() {
            Text(
                text = "Writers: ",
                style = MaterialTheme.typography.subtitle2,
                color = GrayVeryLight
            )

            Text(
                text = movie.writers.joinToString(" _ "),
                style = MaterialTheme.typography.body2,
                color = GrayVeryLight
            )
        }
    }
}