package com.ig81.igshop.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ig81.igshop.domain.usecase.GetAllSportCarsUseCase
import com.ig81.igshop.domain.usecase.GetOfferPreviewUserCase
import com.ig81.igshop.domain.usecase.GetUsersUseCase
import com.ig81.igshop.models.HomeEvent
import com.ig81.igshop.models.HomeViewState
import com.ig81.igshop.models.uimodels.OfferPreviewUiModel
import com.ig81.igshop.models.uimodels.SportCarUiModel
import com.ig81.igshop.models.uimodels.UserUiModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okio.IOException
import java.util.concurrent.TimeoutException

class HomeViewModel(
    private val getAllSportCarsUseCase: GetAllSportCarsUseCase,
    private val getUsersUseCase: GetUsersUseCase,
    private val getOfferPreviewUserCase: GetOfferPreviewUserCase
) : ViewModel() {
    private val _state = MutableStateFlow<HomeViewState>(HomeViewState.Loading)
    val viewState: StateFlow<HomeViewState> = _state.asStateFlow()

    fun obtainEvent(event: HomeEvent) {
        when (val state = _state.value) {
            is HomeViewState.Loading -> {reduce(state,event)}
            is HomeViewState.Display -> {reduce(state, event)}
            else -> {}
        }
    }
    private fun reduce(state: HomeViewState.Loading, event: HomeEvent) {
        when (event) {
            HomeEvent.EnterScreen -> {
               loadHome()
            }

            else -> {}

        }
    }
    private fun reduce(state: HomeViewState.Display, event: HomeEvent) {
        when (event) {
            HomeEvent.ReloadScreen -> {
                loadHome()
            }

            else -> {}

        }
    }


    private fun loadHome() {
        _state.value = HomeViewState.Loading
        viewModelScope.launch {
            try {
                delay(2000)
                val cars = loadCars()

                val user = loadUsers()
                val offer = loadOffers()
                _state.value = HomeViewState.Display(offer, user, cars)
            }catch (e: Exception) {
                val errorMessage = when (e) {
                    is IOException -> "Не удалось загрузить статистику.\n Проверьте ваше интернет-соединение."
                    is TimeoutException -> "Ошибка загрузки: время ожидания истекло.\n Пожалуйста, повторите попытку."

                    else -> "Произошла ошибка.\n Попробуйте еще раз позже."
                }

                _state.value =HomeViewState.Error(
                    message = errorMessage, icon = 2
                )
            }
        }

    }


    private suspend fun loadCars(): List<SportCarUiModel> {
        return getAllSportCarsUseCase().map {
            SportCarUiModel(
                carName = it.name,
                carType = it.type,
                price = it.price,
                rating = it.stars,
                imagePath = it.imagePath
            )
        }
    }


    private suspend fun loadUsers(): List<UserUiModel> {
        return getUsersUseCase(limit = 3).map {
            UserUiModel(
                rankNumber = it.rankNumber,
                name = it.name,
                balls = it.balls,
                imagePath = it.imagePath
            )
        }
    }


    private suspend fun loadOffers(): List<OfferPreviewUiModel> {
        return getOfferPreviewUserCase().map {
            OfferPreviewUiModel(number = it.number)
        }
    }
}
