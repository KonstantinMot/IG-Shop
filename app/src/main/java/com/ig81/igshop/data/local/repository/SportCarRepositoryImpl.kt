package com.ig81.igshop.data.local.repository

import com.ig81.igshop.data.local.entity.SportCarPreview
import com.ig81.igshop.data.local.entity.SportCarSpecification
import com.ig81.igshop.data.local.entity.SportСarDetails
import com.ig81.igshop.domain.repository.SportCarRepository

class SportCarRepositoryImpl:SportCarRepository{
    private val cars = listOf(
        SportCarPreview("Lamba-A", "Классический спорткар", 177000, 4, "file:///android_asset/Shop1.jpg"),
       SportCarPreview("Lamba Sport", "Премиум", 500000, 5,"file:///android_asset/Shop2.jpg"),
        SportCarPreview("Lamborghini Urus", "Внедорожник премиум-класса", 250000, 5,"file:///android_asset/Shop3.jpg")
    )


    private val carDetails = listOf(
        SportСarDetails(
            name = "Lamba-A",
            type = "Классический спорткар",
            stars = 4,
            price = 177000,
            description = "Классика скорости.",
            "file:///android_asset/Shop1.jpg",
            specifications = listOf(
                SportCarSpecification(name = "Скорость", stars = 4),
                SportCarSpecification(name = "Комфорт", stars = 3),
                SportCarSpecification(name = "Мощность", stars = 5)
            )
        ),
        SportСarDetails(
            name = "Lamba Sport",
            type = "Премиум",
            stars = 5,
            price = 500000,
            description = "Премиум автомобиль для ценителей скорости.",
            "file:///android_asset/Shop2.jpg",
            specifications = listOf(
                SportCarSpecification(name = "Скорость", stars = 5),
                SportCarSpecification(name = "Мощность", stars = 5),
                SportCarSpecification(name = "Комфорт", stars = 4)
            )
        ), SportСarDetails(
            name = "Lamborghini Urus",
            type = "Внедорожник премиум-класса",
            stars = 4,
            price = 250000,
            description = "Король внедоложников.",
            "file:///android_asset/Shop3.jpg",
            specifications = listOf(
                SportCarSpecification(name = "Скорость", stars = 4),
                SportCarSpecification(name = "Комфорт", stars = 3),
                SportCarSpecification(name = "Мощность", stars = 5)
            )
        )
    )

    override suspend fun getAllCars(): List<SportCarPreview> {
       return cars
    }

    override suspend fun getCarDetails(carName: String): SportСarDetails {
        return carDetails.find { it.name==carName } ?: throw IllegalArgumentException("Car with name $carName not found")
    }

}
