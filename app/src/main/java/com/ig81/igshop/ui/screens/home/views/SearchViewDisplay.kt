package com.ig81.igshop.ui.screens.home.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.models.SearchEvent
import com.ig81.igshop.models.SearchViewState
import com.ig81.igshop.models.uimodels.SportCarUiModel
import com.ig81.igshop.ui.navigation.NavScreen
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun SearchViewScreen( viewState: SearchViewState.Display,dispatcher: (SearchEvent) -> Unit) {

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

            .padding(32.dp)
    ) {
        SearchWidget(
            values = viewState.query,
            onValueChange = {dispatcher.invoke(SearchEvent.ChangeQuery(it))},
            onClick = { dispatcher.invoke(SearchEvent.CloseScreen) },
        )



        Text(
            text = "Спорткары",
            color = Color(0xFFCACACA),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 18.sp),
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
        )
        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            viewState.sportsCars.forEach { car ->
                SportCarCard(car=car,

                    onClick = {
                        Log.d("SearchEvent", "Car name passed: ${car.carName}")
                        dispatcher.invoke(SearchEvent.OpenScreen(NavScreen.CarPage(car.carName)))}, modifier = Modifier.fillMaxWidth())
            }


        }


    }}


@Preview
@Composable
fun SearchViewScreenPreview() {
    val viewState =SearchViewState.Display( query = "", sportsCars = listOf(
     SportCarUiModel(
            "Lamba-A",
            "Классический спорткар",
            177000,
            4,
            "file:///android_asset/Shop1.jpg"
        ),
        SportCarUiModel(
            "Lamba Sport",
            "Премиум",
            500000,
            5,
            "file:///android_asset/Shop2.jpg"
        ),
        SportCarUiModel(
            "Lamborghini Urus",
            "Внедорожник премиум-класса",
            250000,
            5,
            "file:///android_asset/Shop3.jpg"
        )

    ))

    IGShopTheme {
        SearchViewScreen(viewState,dispatcher = {},)
    }
}