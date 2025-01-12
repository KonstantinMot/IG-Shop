package com.ig81.igshop.ui.screens.achievements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.ig81.igshop.models.AchievementsEvent
import com.ig81.igshop.models.AchievementsViewState
import com.ig81.igshop.ui.screens.home.views.AchievementsViewScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun AchievementsScreen(navController: NavController) {
val viewModel= koinViewModel<AchievementsViewModel>()
    val viewState = viewModel.viewState.collectAsState()
    LaunchedEffect(Unit) { viewModel.obtainEvent(AchievementsEvent.EnterScreen) }



    when (val state = viewState.value) {
        is AchievementsViewState.Display -> {
            AchievementsViewScreen(state) { event ->
                when (event) {


                    AchievementsEvent.CloseScreen -> navController.navigateUp()

                    else -> {
                        viewModel.obtainEvent(event)
                    }
                }
            }

        }

        is AchievementsViewState.Error -> {
        }

        AchievementsViewState.Loading -> {}
    }


}


