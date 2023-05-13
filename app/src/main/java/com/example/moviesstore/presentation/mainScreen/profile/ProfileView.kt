package com.example.moviesstore.presentation.mainScreen.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviesstore.model.User

@Composable
fun ProfileView(
    user: User,
    logout: () -> Unit,
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "My Profile",
                color = MaterialTheme.colors.onSecondary,
                style = MaterialTheme.typography.h3
            )

            IconButton(onClick = logout) {
                Icon(
                    Icons.Default.Logout, ""
                )
            }

        }
        Spacer(Modifier.height(20.dp))
        Row {
            Text(
                text = "email: ",
                style = MaterialTheme.typography.h4,
            )
            Text(
                text = user.email,
                style = MaterialTheme.typography.h5,
            )
        }

    }
}