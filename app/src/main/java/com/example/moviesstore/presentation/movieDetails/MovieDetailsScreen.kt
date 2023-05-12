package com.example.moviesstore.presentation.movieDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesstore.presentation.movieDetails.components.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun MovieDetailsScreen(
    navigator: DestinationsNavigator,
    id: Int,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) = viewModel.run {
    Scaffold() {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val space = 8.dp
            movie?.let {
                TopAppBar(title = it.title){
                    navigator.popBackStack()
                }
                YoutubeView(videoId = it.youtube_video_id)
                Spacer(Modifier.height(space+8.dp))
                ImageAndName(movie = it){
                    addToWatchList()
                }
                Spacer(Modifier.height(space))
                SummaryDirectiveWriters(it,space)
                Spacer(Modifier.height(space))
                CastList(actors = it.actors, space = space)
            }

        }
    }
}