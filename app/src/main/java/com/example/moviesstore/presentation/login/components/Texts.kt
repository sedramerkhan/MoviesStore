package com.example.moviesstore.presentation.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moviesstore.ui.theme.GrayVeryLight

@Composable
fun Texts(){
    Column(Modifier.fillMaxWidth()) {
        Text(
            "Welcome",
            style = MaterialTheme.typography.h1
        )
        Text(
            "Login to continue",
            color = GrayVeryLight,
            style = MaterialTheme.typography.h3
        )

    }
}