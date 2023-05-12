package com.example.moviesstore.presentation.movieDetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.moviesstore.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun YoutubeView(
    videoId: String,
    modifier: Modifier = Modifier
) {
    var play by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp), shape = RoundedCornerShape(20.dp)
    ) {
        if (play) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = {
                    val view = YouTubePlayerView(it)
                    view.addYouTubePlayerListener(
                        object : AbstractYouTubePlayerListener() {
                            override fun onReady(youTubePlayer: YouTubePlayer) {
                                super.onReady(youTubePlayer)
                                youTubePlayer.loadVideo(videoId, 0f)
                            }
                        }
                    )
                    view
                })
        } else {
            Box(
                modifier
                    .fillMaxSize()
                    .clickable { play = true }) {
                Image(
                    painterResource(id = R.drawable.play_circle), "",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }

}