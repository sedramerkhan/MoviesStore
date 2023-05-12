package com.example.moviesstore.presentation.mainScreen.components

import com.example.moviesstore.R



sealed class BottomNavItem(var icon:Int,var coloredIcon:Int, var view: View){

    object Home : BottomNavItem( R.drawable.home,R.drawable.home_1, View.MOVIES_CATEGORIES)
    object WatchList : BottomNavItem( R.drawable.desktop_1,R.drawable.desktop,View.WATCH_LIST)
    object Profile : BottomNavItem( R.drawable.user,R.drawable.user, View.PROFILE)

}

val ITEMS = listOf(
    BottomNavItem.Home, BottomNavItem.WatchList, BottomNavItem.Profile
)
