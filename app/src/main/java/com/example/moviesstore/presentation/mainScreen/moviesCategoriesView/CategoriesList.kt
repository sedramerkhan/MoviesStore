package com.example.moviesstore.presentation.mainScreen.moviesCategoriesView

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.moviesstore.model.Category
import kotlinx.coroutines.delay

@Composable
fun CategoriesList(
    categories: List<Category>,
    onClick: (Category) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories) {
            CategoryItem(modifier = Modifier, category = it) {
                onClick(it)
            }
        }

    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryItem(
    modifier: Modifier,
    category: Category,
    onClick: () -> Unit,
) {
    var animate by remember{
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit){
        delay(100)
        animate = true
    }
    BoxWithConstraints() {
        val size by animateDpAsState(
            targetValue = if (animate) maxWidth else 0.dp
        )
    Card(
        onClick =  onClick,
        modifier = modifier
            .size(size)
            .aspectRatio(1.2f),
        shape= RoundedCornerShape(25.dp),
        backgroundColor = MaterialTheme.colors.onBackground
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = category.title,
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
            )
        }
    }
    }
}