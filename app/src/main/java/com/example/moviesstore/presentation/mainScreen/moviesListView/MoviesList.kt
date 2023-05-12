package com.example.moviesstore.presentation.mainScreen.moviesListView

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.moviesstore.R
import com.example.moviesstore.model.Movie

@Composable
fun MoviesList(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    onClick: (Int) -> Unit,
) {
    LazyColumn(
        modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(movies) {
            MovieCard(movie = it) {
                onClick(it.id)
            }
        }
    }
}


@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    movie: Movie,
    onClick: () -> Unit,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onClick() }
    ) {
        val round = 8.dp
        MovieImage(movie_id = movie.id, round)
        Spacer(modifier = Modifier.width(5.dp))
        MovieDetails(movie = movie, round)
    }
}

@Composable
fun MovieImage(movie_id: Int, round: Dp) {
    val path = "https://darsoft.b-cdn.net/assets/movies/${movie_id}.jpg"
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(path)
//            .size(Size.ORIGINAL) // Set the target size to load the image at.
            .crossfade(true)
            .build()
    )

    Card(
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(.9f),
        shape = RoundedCornerShape(round),
        backgroundColor = MaterialTheme.colors.onBackground
    ) {
        if (painter.state is AsyncImagePainter.State.Loading) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }

        Image(
            painter = painter,
            contentDescription = "movie",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun MovieDetails(
    movie: Movie,
    round: Dp
) {
    Surface(modifier = Modifier.fillMaxSize(), shape = RoundedCornerShape(round)) {
        Column(
            Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.h4
            )
            Text(
                text = movie.year,
                style = MaterialTheme.typography.h5
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.star), ""
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "${movie.rating}/10",
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}