package com.ig81.igshop.models

import com.ig81.igshop.models.uimodels.UserUiModel
import com.ig81.igshop.ui.screens.home.views.User

sealed class AchievementsViewState {
    data object Loading : AchievementsViewState()
    data class Error(val message: String, val icon: Int): AchievementsViewState()
    data class Display(val regularCustomers:List<UserUiModel>, val vipCustomers:List<UserUiModel>,val tabIndex: Int): AchievementsViewState()}