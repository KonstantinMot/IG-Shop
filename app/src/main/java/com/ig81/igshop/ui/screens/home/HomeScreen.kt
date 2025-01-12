package com.ig81.igshop.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.ig81.igshop.models.HomeEvent
import com.ig81.igshop.models.HomeViewState
import com.ig81.igshop.ui.screens.home.views.HomeViewDisplay
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel= koinViewModel<HomeViewModel>()
val viewState=viewModel.viewState.collectAsState()
    LaunchedEffect(Unit) {viewModel.obtainEvent(HomeEvent.EnterScreen)}


    when (val state = viewState.value) {
        is HomeViewState.Display -> {
            HomeViewDisplay(state) { event ->
                when (event) {
                    is HomeEvent.OpenScreen -> navController.navigate(event.screen)
                    else->{viewModel.obtainEvent(event)}
                }


            }
        }

        is HomeViewState.Error -> {

        }
        HomeViewState.Loading -> {

        }
    }
}





