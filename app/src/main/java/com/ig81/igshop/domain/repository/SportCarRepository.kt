package com.ig81.igshop.domain.repository


import com.ig81.igshop.data.local.entity.SportCarPreview
import com.ig81.igshop.data.local.entity.SportСarDetails

interface SportCarRepository{
    suspend fun getAllCars():List<SportCarPreview>
    suspend fun getCarDetails(carName:String):SportСarDetails
}