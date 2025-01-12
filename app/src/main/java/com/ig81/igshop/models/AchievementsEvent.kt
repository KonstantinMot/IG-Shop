package com.ig81.igshop.models

sealed class AchievementsEvent {
    data object EnterScreen : AchievementsEvent()
    data object ReloadScreen : AchievementsEvent()
    data class ChangeQuery(val newValue:String): AchievementsEvent()
    data class ChangeTab(val tabIndex: Int):AchievementsEvent()
    data object CloseScreen:AchievementsEvent()

}