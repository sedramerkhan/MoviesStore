package com.example.moviesstore.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.moviesstore.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TopAppBar(
    searchValue: String,
    onValueChanged: (String) -> Unit,
    onDone: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Movies Store",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
            )
            Icon(
                painterResource(id = R.drawable.bell), "bell",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 20.dp)
            )
        }

        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(.85f),
            value = searchValue, onValueChange = onValueChanged,
            placeholder = {
                Text(
                    "search",
                    style = MaterialTheme.typography.body1
                )
            },
            shape = RoundedCornerShape(35.dp),
            leadingIcon = {
                Icon(painterResource(id = R.drawable.search), "search")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(onDone = {
                onDone()
                keyboardController?.hide()
            })
        )
    }

}