package com.ig81.igshop.data.local.entity

import androidx.compose.ui.graphics.Path

data class SportСarDetails(
    val name: String,
    val type: String,
    val stars: Int,
    val price: Int,
    val description: String,
    val imagePath:String,
    val specifications: List<SportCarSpecification>
)