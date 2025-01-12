package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ig81.igshop.R
import com.ig81.igshop.models.HomeEvent
import com.ig81.igshop.models.HomeViewState
import com.ig81.igshop.models.uimodels.OfferPreviewUiModel
import com.ig81.igshop.models.uimodels.SportCarUiModel
import com.ig81.igshop.models.uimodels.UserUiModel
import com.ig81.igshop.ui.navigation.NavScreen
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetSearchField

@Composable
fun HomeViewDisplay(viewState: HomeViewState.Display, dispatch: (HomeEvent) -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    )
    {

        Row(
            Modifier.padding(start = 32.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            JetSearchField(stringResource(R.string.search_hint),
                "",
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .clickable { dispatch.invoke(HomeEvent.OpenScreen(NavScreen.Search)) }
                    .weight(1f))
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_81_ig),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 5.dp)

            )


        }

        SpecialOffersWidget(
            specialOffers = viewState.specialOffers,
            modifier = Modifier.clickable { })
        Spacer(Modifier.height(32.dp))
        AchievementsWidget(
            topCustomers = viewState.topCustomers,
            onClick = { dispatch.invoke(HomeEvent.OpenScreen(NavScreen.Achievements)) },
            title =
            stringResource(R.string.achievements_and_awards_title),
            icon = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_filter_24_filled,

            modifier = Modifier.padding(32.dp)
        )
        Spacer(Modifier.height(32.dp))
        SportsCarsWidget(cars = viewState.newProducts, onClickCar = { carName ->
            dispatch.invoke(
                HomeEvent.OpenScreen(
                    NavScreen.CarPage(
                        carName
                    )
                )
            )
        })

    }
}


@Preview
@Composable
fun HomeViewDisplayPreview() {
    val state = HomeViewState.Display(
        specialOffers = listOf(
          OfferPreviewUiModel(  "103 436"),
            OfferPreviewUiModel( "105 423"),
            OfferPreviewUiModel  ("121 453"),
            OfferPreviewUiModel( "364 154")
        ), topCustomers = listOf(
            UserUiModel(1,  "Джонни Джонсон", 150),
            UserUiModel(2,  "Мэри Мэроу", 120),
            UserUiModel(3,  "Дики Дуо", 100),
            UserUiModel(4,  "Рикки Ру", 180),
            UserUiModel(5,  "Тин Тин", 160)
        ), newProducts = listOf(
            SportCarUiModel("Lamba-A", "Классический спорткар", 177000, 4, ""),
            SportCarUiModel("Lamba Sport", "Премиум", 500000, 5, ""),
            SportCarUiModel("Lamborghini Urus", "Внедорожник премиум-класса", 250000, 5, "")
        )
    )
    IGShopTheme { HomeViewDisplay(state, dispatch = {}) }
}