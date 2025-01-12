package com.ig81.igshop.models

sealed class CarPageEvent {
    data class EnterScreen(val carName:String) : CarPageEvent()
    data object ReloadScreen : CarPageEvent()
    data object BookCar:CarPageEvent()
    data object CloseScreen:CarPageEvent()

}