package com.example.moviesstore.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.moviesstore.R

@Composable
fun Loading(
    modifier: Modifier = Modifier,
    size: Dp = 150.dp
) {
    Box(modifier.fillMaxSize()) {
        val compositionResult: LottieCompositionResult =
            rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading)) //it can be stored in asset too

        val progress by animateLottieCompositionAsState(
            compositionResult.value,
            isPlaying = true,
            iterations = LottieConstants.IterateForever,
            speed = 1.5f
        )

        LottieAnimation(
            compositionResult.value, { progress },
            modifier = Modifier
                .size(size)
                .align(Alignment.Center)
        )
    }

}