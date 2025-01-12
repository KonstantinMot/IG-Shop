package com.ig81.igshop.ui.screens.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.ig81.igshop.models.SearchEvent
import com.ig81.igshop.models.SearchViewState
import com.ig81.igshop.ui.screens.home.views.SearchViewScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(navController: NavController) {
    val viewModel= koinViewModel<SearchViewModel>()
   val viewState =viewModel.viewState.collectAsState()
    LaunchedEffect(Unit) {viewModel.obtainEvent(SearchEvent.ReloadScreen) }
    when ( val state=viewState.value) {
        is SearchViewState.Loading -> {}
        is SearchViewState.Display -> {
            SearchViewScreen(state) { event ->
                when (event) {

                    is SearchEvent.CloseScreen -> navController.navigateUp()

                    is SearchEvent.OpenScreen ->navController.navigate(event.screen)
                  else->{viewModel.obtainEvent(event)}
                }
            }
        }

        is SearchViewState.Error -> {

        }
    }


}



