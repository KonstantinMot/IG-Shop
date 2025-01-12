package com.ig81.igshop.models

import com.ig81.igshop.ui.navigation.NavScreen

sealed class SearchEvent {
    data class ChangeQuery(val newValue:String) : SearchEvent()
    data object ReloadScreen : SearchEvent()
    data object CloseScreen:SearchEvent()
    data class OpenScreen(val screen:NavScreen):SearchEvent()


}