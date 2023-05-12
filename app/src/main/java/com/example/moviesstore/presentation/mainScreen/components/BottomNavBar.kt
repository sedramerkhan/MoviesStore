package com.example.moviesstore.presentation.mainScreen.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.moviesstore.ui.theme.GraySuperBold
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun BottomNavBar(
    currentView: View,
    changeCurrentView: (View)-> Unit,
    navigator: DestinationsNavigator,
    items: List<BottomNavItem> = ITEMS,
) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items.forEach {
            val checkCurrent = it.view == currentView
            BottomNavigationItem(
                modifier = Modifier.background(GraySuperBold),
                selected = checkCurrent,
                 selectedContentColor = MaterialTheme.colors.primary,
                 unselectedContentColor = MaterialTheme.colors.onBackground,
                onClick = {
                    if (!checkCurrent)
                        changeCurrentView(it.view)
                }, icon = {
                    Icon(
                        painter = painterResource(id = if (checkCurrent) it.coloredIcon else it.icon),
                        contentDescription = ""
                    )
                })

        }
    }
}