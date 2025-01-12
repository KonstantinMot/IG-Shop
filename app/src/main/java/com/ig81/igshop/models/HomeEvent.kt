package com.ig81.igshop.models

import com.ig81.igshop.ui.navigation.NavScreen

sealed class HomeEvent {
    data object EnterScreen : HomeEvent()
    data object ReloadScreen : HomeEvent()
    data class  OpenScreen(val screen: NavScreen):HomeEvent()

}