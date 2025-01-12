package com.ig81.igshop.domain.usecase

import com.ig81.igshop.data.local.entity.SportСarDetails
import com.ig81.igshop.domain.repository.SportCarRepository

class GetSportCarDetailsUseCase (private val repository: SportCarRepository){
    suspend operator fun invoke(carName:String):SportСarDetails{
        return repository.getCarDetails(carName)
    }
}