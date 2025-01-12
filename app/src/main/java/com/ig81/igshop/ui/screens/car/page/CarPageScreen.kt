package com.ig81.igshop.ui.screens.car.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.ig81.igshop.models.CarPageEvent
import com.ig81.igshop.models.CarPageViewState
import com.ig81.igshop.ui.screens.home.views.CarPageViewDisplay
import org.koin.androidx.compose.koinViewModel

@Composable
fun CarPageScreen(navController: NavController, carName: String) {
    val viewModel= koinViewModel<CarPageViewModel>()
    val viewState = viewModel.viewState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.obtainEvent(CarPageEvent.EnterScreen(carName))
    }



    when (val state = viewState.value) {
        is CarPageViewState.Display -> {
            CarPageViewDisplay(state) { event ->
                when (event) {
                    CarPageEvent.BookCar -> {
                    }

                    CarPageEvent.CloseScreen -> navController.navigateUp()
                    else -> {
                        viewModel.obtainEvent(event)
                    }
                }
            }
        }

        is CarPageViewState.Error -> {}
        CarPageViewState.Loading -> {}
    }


}
