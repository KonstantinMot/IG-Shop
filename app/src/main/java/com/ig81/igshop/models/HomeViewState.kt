package com.ig81.igshop.models

import com.ig81.igshop.models.uimodels.OfferPreviewUiModel
import com.ig81.igshop.models.uimodels.SportCarUiModel
import com.ig81.igshop.models.uimodels.UserUiModel

sealed class HomeViewState {
    data object Loading : HomeViewState()
    data class Error(val message: String, val icon: Int) : HomeViewState()
    data class Display(
        val specialOffers: List<OfferPreviewUiModel>,
        val topCustomers: List<UserUiModel>,
        val newProducts: List<SportCarUiModel>
    ) : HomeViewState()

}