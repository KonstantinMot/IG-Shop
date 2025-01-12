package com.ig81.igshop.ui.screens.car.page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ig81.igshop.domain.usecase.GetSportCarDetailsUseCase
import com.ig81.igshop.models.CarPageEvent
import com.ig81.igshop.models.CarPageViewState
import com.ig81.igshop.models.uimodels.SpecificationUiModel

import com.ig81.igshop.models.uimodels.SportCarUiModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okio.IOException
import java.util.concurrent.TimeoutException

class CarPageViewModel(private val getSportCarDetailsUseCase: GetSportCarDetailsUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow<CarPageViewState>(CarPageViewState.Loading)
    val viewState: StateFlow<CarPageViewState> = _state.asStateFlow()

    fun obtainEvent(event: CarPageEvent) {
        when (val state = _state.value) {
            is CarPageViewState.Display -> reduce(state, event)
            is CarPageViewState.Loading -> reduce(state, event)
            else -> {}
        }
    }

    private fun reduce(state: CarPageViewState.Loading, event: CarPageEvent) {
        when (event) {
            is CarPageEvent.EnterScreen -> loadCarDetails(event.carName)

            else -> {}
        }

    }

    private fun reduce(state: CarPageViewState.Display, event: CarPageEvent) {
        when (event) {
            CarPageEvent.BookCar -> TODO()
            CarPageEvent.ReloadScreen -> reloadDetails()
            else -> {}


        }
    }

    private fun loadCarDetails(carName: String) {
        _state.value = CarPageViewState.Loading
        viewModelScope.launch{
        try {
            delay(2000)
            val carDetails=loadDetails(carName)
            val car=loadCar(carName)
            _state.value=CarPageViewState.Display(car,carDetails,)

        } catch (e: Exception) {
            val errorMessage = when (e) {
                is IOException -> "Не удалось загрузить статистику.\n Проверьте ваше интернет-соединение."
                is TimeoutException -> "Ошибка загрузки: время ожидания истекло.\n Пожалуйста, повторите попытку."

                else -> "Произошла ошибка.\n Попробуйте еще раз позже."
            }

            _state.value = CarPageViewState.Error(
                message = errorMessage, icon = 2
            )
        }
    }}

    private suspend fun loadDetails(carName: String): List<SpecificationUiModel> {
        val details = getSportCarDetailsUseCase(carName)
        return details.specifications.map { spec->SpecificationUiModel(name = spec.name, rating = spec.stars) }

    }

    private suspend fun loadCar(carName: String):SportCarUiModel{
        val car=getSportCarDetailsUseCase(carName)
        return SportCarUiModel(carName=car.name, carType = car.type, price = car.price, rating = car.stars, imagePath = car.imagePath, description = car.description)
    }
    private fun reloadDetails(){
        val currentState=_state.value
        if(currentState is CarPageViewState.Display){loadCarDetails(currentState.car.carName)}
    }

}

