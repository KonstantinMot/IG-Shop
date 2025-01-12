package com.ig81.igshop.di

import com.ig81.igshop.data.local.repository.OfferRepositoryImpl
import com.ig81.igshop.data.local.repository.SportCarRepositoryImpl
import  com.ig81.igshop.domain.repository.UserRepository
import com.ig81.igshop.data.local.repository.UserRepositoryImpl
import com.ig81.igshop.domain.repository.OfferRepository
import com.ig81.igshop.domain.repository.SportCarRepository
import com.ig81.igshop.domain.usecase.GetAllSportCarsUseCase
import com.ig81.igshop.domain.usecase.GetOfferPreviewUserCase
import com.ig81.igshop.domain.usecase.GetSportCarDetailsUseCase
import com.ig81.igshop.domain.usecase.GetUsersUseCase
import com.ig81.igshop.ui.screens.achievements.AchievementsViewModel
import com.ig81.igshop.ui.screens.car.page.CarPageViewModel
import com.ig81.igshop.ui.screens.home.HomeViewModel
import com.ig81.igshop.ui.screens.search.SearchViewModel

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
singleOf(::SportCarRepositoryImpl) {bind<SportCarRepository>()}
singleOf(::OfferRepositoryImpl){bind<OfferRepository>()}
    factoryOf(::GetAllSportCarsUseCase)
    factoryOf(::GetOfferPreviewUserCase)
    factoryOf(::GetSportCarDetailsUseCase)
    factoryOf(::GetUsersUseCase)
    viewModelOf(::AchievementsViewModel)
    viewModelOf(::CarPageViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
}
