package com.example.moviesstore.presentation.movieDetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.moviesstore.R
import com.example.moviesstore.model.Movie

@Composable
fun ImageAndName(
    movie: Movie,
    addToWatchList: ()-> Unit,
) {

    Row() {
        val height = 170.dp
        MovieImage(movie_id = movie.id, round = 8.dp, height = height)
        Spacer(Modifier.width(20.dp))
        MovieDetails(movie = movie, height = height){
            addToWatchList()
        }
    }

}


@Composable
fun MovieImage(movie_id: Int, round: Dp, height: Dp) {
    val path = "https://darsoft.b-cdn.net/assets/movies/${movie_id}.jpg"
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(path)
            .crossfade(true)
            .build()
    )

    Card(
        modifier = Modifier
            .height(height)
            .aspectRatio(.65f),
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
    height: Dp,
    addToWatchList: () -> Unit,
) {
    Column(
        Modifier.height(height).padding(top=20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = movie.title,
            style = MaterialTheme.typography.h4
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = movie.year,
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.W400)
            )
            Spacer(Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.star), "",
                modifier =Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "${movie.rating}/10",
                style = MaterialTheme.typography.subtitle1
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth(.9f),
            onClick = addToWatchList,
            shape = RoundedCornerShape(30.dp),
        ) {
            Text(
                text = "Add to Watchlist",
                style = MaterialTheme.typography.button
            )
        }
    }
}