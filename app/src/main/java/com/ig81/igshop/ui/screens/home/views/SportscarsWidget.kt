package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.R
import com.ig81.igshop.models.uimodels.SportCarUiModel
import com.ig81.igshop.ui.theme.IGShopTheme



@Composable
fun SportsCarsWidget(cars:List<SportCarUiModel>,onClickCar:(String)->Unit) {

    Column(Modifier.padding(start = 32.dp)) {
        Text(
            text = stringResource(R.string.our_new_products_title),
            color = Color(0xFFCACACA),
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 18.sp),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(cars) { car ->
                SportCarCard(
                    car=car,
                    onClick = {onClickCar(car.carName)}
                )
            }
        }

    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0x2E4552
)
@Composable
fun SportsCarsWidgetPreview() {
    IGShopTheme { SportsCarsWidget(cars = listOf(
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
        ))
        , onClickCar = {carName-> println("Переход на страницу $carName") }) }
}