package com.example.moviesstore.presentation.movieDetails.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBar(title: String,onClick: ()-> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = title,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center,
        )
        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Default.ArrowBackIos,
                modifier = Modifier
                    .align(Alignment.CenterStart),
                contentDescription = ""
            )
        }

    }
    Spacer(Modifier.height(10.dp))
}