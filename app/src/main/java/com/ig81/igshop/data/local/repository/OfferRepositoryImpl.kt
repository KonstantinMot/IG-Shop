package com.ig81.igshop.data.local.repository

import com.ig81.igshop.data.local.entity.OfferDetails
import com.ig81.igshop.data.local.entity.OfferPreview
import com.ig81.igshop.domain.repository.OfferRepository

class OfferRepositoryImpl:OfferRepository{


   private val offer =listOf(
    OfferPreview(1, "103 436"),
    OfferPreview(2, "105 423"),
       OfferPreview(3, "121 453"),
       OfferPreview(4, "364 154")
    )
    override suspend fun getOfferPreview(): List<OfferPreview> {
       return offer
    }

    override suspend fun getOfferDetails(id: Int): OfferDetails {
        return OfferDetails(id, "Special Offer $id", "Описание для предложения $id")
    }
}