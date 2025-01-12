package com.ig81.igshop.ui.navigation


import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
sealed class NavScreen() {
    @Serializable
    data object Home : NavScreen()
    @Serializable
    data object Achievements : NavScreen()
    @Serializable
    data object Search : NavScreen()
    @Serializable
    data class CarPage (val carName:String ) : NavScreen()}
