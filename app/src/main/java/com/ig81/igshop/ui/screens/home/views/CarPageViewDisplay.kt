package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.data.local.entity.SportCarSpecification
import com.ig81.igshop.models.CarPageEvent
import com.ig81.igshop.models.CarPageViewState
import com.ig81.igshop.models.uimodels.SpecificationUiModel
import com.ig81.igshop.models.uimodels.SportCarUiModel
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetDescriptionCard
import com.ig81.igshop.ui.theme.components.JetIconButton
import com.ig81.igshop.ui.theme.components.JetSpecificationCard
import com.microsoft.fluent.mobile.icons.R

@Composable
fun CarPageViewDisplay(viewState: CarPageViewState.Display, dispatcher: (CarPageEvent) -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(32.dp)
    ) {

        JetIconButton(
            R.drawable.ic_fluent_chevron_left_16_filled,
            modifier = Modifier.size(48.dp),
            shape = MaterialTheme.shapes.small,
            contentPadding = PaddingValues(12.dp),
            onClick = { dispatcher.invoke(CarPageEvent.CloseScreen) })
        Spacer(Modifier.height(32.dp))
        SportCarCard(viewState.car)
        Spacer(Modifier.height(32.dp))
        JetSpecificationCard(viewState.specification)
        HorizontalDivider(
            Modifier.padding(start = 33.dp, top = 17.dp, end = 33.dp, bottom = 17.dp),
            thickness = 2.dp,
            color = Color(0xFFFFFFFF).copy(0.25f)
        )
        JetDescriptionCard(viewState.car.description)
        Spacer(Modifier.weight(1f))

        Button(
            onClick = {}, modifier = Modifier.fillMaxWidth(),


            border = BorderStroke(4.dp, color = Color(0xFF000000).copy(0.5f)),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color(0xFF000000).copy(0.5f),

                ), contentPadding = PaddingValues(18.dp)
        ) {
            Text(
                "Отправить заявку",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 16.sp)
            )
        }

    }



}

@Preview
@Composable
fun CarPageViewDisplayPreview() {

    val state = CarPageViewState.Display(
        car = SportCarUiModel("Lamba-A", "Классический спорткар", 177000, 4, "", description = "\"Лучший спорткар на всём Внешнем кольце. Его модернезированные \" +\n" +
                "                \"версии завоевывают первые места на всех крупных соревнованиях в галактике!\""),
      specification = listOf(
         SpecificationUiModel(name = "Скорость", 4),
          SpecificationUiModel(name = "Комфорт", 3),
          SpecificationUiModel(name = "Мощность", 5)
      )

    )
    IGShopTheme { CarPageViewDisplay(state) { } }
}