package com.ig81.igshop.models

sealed class CarPageAction{
    data class ShowDialog(val title: String,
                          val body: String,
                          val buttonText: String):CarPageAction()
}