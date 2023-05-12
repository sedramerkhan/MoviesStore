package com.example.moviesstore.presentation.movieDetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.moviesstore.R
import com.example.moviesstore.model.Actor

@Composable
fun CastList(
    actors: List<Actor>,
    space: Dp,
) {
    Column() {
        Text(
            text = "Cast",
            style = MaterialTheme.typography.h4
        )
        Spacer(Modifier.height(space))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(space)) {
            items(actors) {
                CastItem(actor = it, size = 70.dp, space = space)
            }
        }
    }
}

@Composable
fun CastItem(actor: Actor, size: Dp, space: Dp) {
    val path = "https://darsoft.b-cdn.net/assets/artists/${actor.id}.jpg"
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(path)
            //            .placeholder(R.drawable.actor)
            .error(R.drawable.actor)
            .crossfade(true)
            .build()
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card(
            modifier = Modifier
                .size(size),
            shape = CircleShape,
            backgroundColor = MaterialTheme.colors.onBackground
        ) {
            if (painter.state is AsyncImagePainter.State.Loading) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.size(size/3))
                }
            }

            Image(
                painter = painter,
                contentDescription = "actor",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(Modifier.height(space))

        Text(
            text = actor.name,
            style = MaterialTheme.typography.body2
        )
    }


}