package com.example.moviesstore.presentation.mainScreen.MoviesCategoriesView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviesstore.model.Category

@Composable
fun MoviesCategoriesView(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onClick: (Int)-> Unit,
) {
    Column(modifier) {
        Text(
            "Trending Categories",
            style = MaterialTheme.typography.h4
        )
        
        Spacer(Modifier.height(20.dp))
        
        CategoriesList(categories = categories, onClick = onClick)
    }

}


