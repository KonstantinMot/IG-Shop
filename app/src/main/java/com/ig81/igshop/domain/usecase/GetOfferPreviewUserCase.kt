package com.ig81.igshop.domain.usecase

import com.ig81.igshop.data.local.entity.OfferPreview
import com.ig81.igshop.domain.repository.OfferRepository

class GetOfferPreviewUserCase (private val repository: OfferRepository){
    suspend operator fun invoke():List<OfferPreview>{
        return repository.getOfferPreview()

    }
}