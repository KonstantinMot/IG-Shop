package com.ig81.igshop.ui.screens.achievements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ig81.igshop.domain.usecase.GetUsersUseCase
import com.ig81.igshop.models.AchievementsEvent
import com.ig81.igshop.models.AchievementsViewState
import com.ig81.igshop.models.uimodels.UserUiModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okio.IOException
import java.util.concurrent.TimeoutException

class AchievementsViewModel(val getUsersUseCase: GetUsersUseCase) : ViewModel() {
    private val _state = MutableStateFlow<AchievementsViewState>(AchievementsViewState.Loading)
    val viewState: StateFlow<AchievementsViewState> = _state.asStateFlow()
    fun obtainEvent(event: AchievementsEvent) {
        when (val state = _state.value) {
            is AchievementsViewState.Loading -> {
                reduce(state, event)
            }

            is AchievementsViewState.Display -> {
                reduce(state, event)
            }

            else -> {}
        }
    }

    private fun reduce(state: AchievementsViewState.Loading, event: AchievementsEvent) {
        when (event) {
            is AchievementsEvent.EnterScreen -> {
                loadHome()
            }

            else -> {}

        }
    }

    private fun reduce(state: AchievementsViewState.Display, event: AchievementsEvent) {
        when (event) {
            AchievementsEvent.ReloadScreen -> {
                loadHome()
            }

            is AchievementsEvent.ChangeTab -> {
                _state.value = state.copy(tabIndex = event.tabIndex)
            }


            else -> {}

        }
    }


    private fun loadHome() {
        _state.value = AchievementsViewState.Loading
        viewModelScope.launch {
            try {
                delay(2000)
                val users = loadUsers()
                val userVip = loadVipUsers()
                val selectTabIndex: Int = 0
                _state.value = AchievementsViewState.Display(users, userVip, selectTabIndex)
            } catch (e: Exception) {
                val errorMessage = when (e) {
                    is IOException -> "Не удалось загрузить статистику.\n Проверьте ваше интернет-соединение."
                    is TimeoutException -> "Ошибка загрузки: время ожидания истекло.\n Пожалуйста, повторите попытку."

                    else -> "Произошла ошибка.\n Попробуйте еще раз позже."
                }

                _state.value = AchievementsViewState.Error(
                    message = errorMessage, icon = 2
                )
            }
        }

    }


    private suspend fun loadVipUsers(): List<UserUiModel> {
        return getUsersUseCase(onlyVip = true).map {
            UserUiModel(
                rankNumber = it.rankNumber,
                name = it.name,
                balls = it.balls,
                imagePath = it.imagePath
            )
        }
    }

    private suspend fun loadUsers(): List<UserUiModel> {
        return getUsersUseCase(onlyVip = false).map {
            UserUiModel(
                rankNumber = it.rankNumber,
                name = it.name,
                balls = it.balls,
                imagePath = it.imagePath
            )
        }
    }
}


