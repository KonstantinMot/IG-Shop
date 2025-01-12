package com.ig81.igshop.domain.repository

import com.ig81.igshop.data.local.entity.OfferDetails
import com.ig81.igshop.data.local.entity.OfferPreview

interface OfferRepository {
    suspend fun getOfferPreview():List<OfferPreview>
    suspend fun getOfferDetails(id:Int):OfferDetails
}