package com.ig81.igshop.models

import com.ig81.igshop.models.uimodels.SpecificationUiModel

import com.ig81.igshop.models.uimodels.SportCarUiModel

sealed class CarPageViewState {
    data object Loading : CarPageViewState()
    data class Error(val message: String, val icon: Int) : CarPageViewState()
    data class Display(
      val car:SportCarUiModel,
        val specification:List<SpecificationUiModel>,

    ) : CarPageViewState()

}
