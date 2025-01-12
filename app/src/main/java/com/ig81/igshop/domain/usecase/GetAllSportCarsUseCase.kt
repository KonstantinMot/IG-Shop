package com.ig81.igshop.domain.usecase

import com.ig81.igshop.data.local.entity.SportCarPreview
import com.ig81.igshop.domain.repository.SportCarRepository

class GetAllSportCarsUseCase(private val sportCarRepository: SportCarRepository) {
    suspend operator fun invoke(query: String? = null): List<SportCarPreview> {
        val allCars = sportCarRepository.getAllCars()
        return if (!query.isNullOrBlank()) {
            allCars.filter { it.name.contains(query, ignoreCase = true) }
        } else {
            allCars
        }


    }
}