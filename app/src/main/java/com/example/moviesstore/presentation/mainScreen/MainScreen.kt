package com.example.moviesstore.presentation.mainScreen

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesstore.presentation.destinations.MovieDetailsScreenDestination
import com.example.moviesstore.presentation.home.components.TopAppBar
import com.example.moviesstore.presentation.mainScreen.moviesCategoriesView.MoviesCategoriesView
import com.example.moviesstore.presentation.mainScreen.components.BottomNavBar
import com.example.moviesstore.presentation.mainScreen.components.View
import com.example.moviesstore.presentation.mainScreen.moviesListView.MoviesListView
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalAnimationApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen(
    navigator: DestinationsNavigator,
    viewModel: MainViewModel = hiltViewModel()
) = viewModel.run{

    BackHandler(currentView == View.MOVIES_LIST) {
        currentView = View.MOVIES_CATEGORIES
    }
    Scaffold(
        bottomBar = {
            BottomNavBar( navigator =navigator, currentView = currentView, changeCurrentView = {
                currentView = it
            })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(20.dp)
        ){
            TopAppBar(searchValue, onValueChanged = {
                searchValue = it
            }, onDone =::search
            )
            Spacer(Modifier.height(20.dp))

            AnimatedContent(targetState = currentView) {
                when(it){
                    View.MOVIES_CATEGORIES -> {
                        MoviesCategoriesView(categories = categories, onClick = ::onCategoryClicked)
                    }
                    View.MOVIES_LIST ->{
                        MoviesListView(title = chosenCategory!!.title, movies =movieListCategory , onClick ={
                            navigator.navigate(MovieDetailsScreenDestination(it))
                        } )

                    }
                    View.WATCH_LIST ->{
                        Text( View.WATCH_LIST.name)

                    }
                    View.PROFILE -> {
                        Text( View.PROFILE.name)

                    }

                }

            }
        }
    }
}