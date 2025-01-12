package com.ig81.igshop.ui.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ig81.igshop.domain.usecase.GetAllSportCarsUseCase
import com.ig81.igshop.models.SearchEvent
import com.ig81.igshop.models.SearchViewState
import com.ig81.igshop.models.uimodels.SportCarUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class SearchViewModel(val getAllSportCarsUseCase: GetAllSportCarsUseCase) : ViewModel() {
    private val _state = MutableStateFlow<SearchViewState>(SearchViewState.Loading)
    val viewState: StateFlow<SearchViewState> = _state.asStateFlow()


    fun obtainEvent(event: SearchEvent) {
        when (val state = _state.value) {
            is SearchViewState.Loading -> {
                reduce(state, event)
           }

            is SearchViewState.Display -> {
                reduce(state, event)
            }

            else -> {}
        }
    }

    private fun reduce(state: SearchViewState.Loading, event: SearchEvent) {
        when (event) {
            SearchEvent.ReloadScreen -> {performSearch("")

            }

            else -> {}

        }
    }

    private fun reduce(state: SearchViewState.Display, event: SearchEvent) {
        when (event) {


            is SearchEvent.ChangeQuery->{performSearch(event.newValue)}


            else -> {}

        }
    }

    private fun performSearch(query: String) {
        viewModelScope.launch {
            try {
                val car = loadCar(query)
                _state.value = SearchViewState.Display(query = query, car)
            } catch (e: Exception) {

                _state.value = SearchViewState.Error("Произошла ошибка: ${e.message}", 2)
            }
        }
    }


    private suspend fun loadCar(query: String): List<SportCarUiModel> {
        return getAllSportCarsUseCase(query).map {
            SportCarUiModel(
                carName = it.name,
                carType = it.type,
                price = it.price,
                rating = it.stars,
                imagePath = it.imagePath
            )
        }


    }

}

