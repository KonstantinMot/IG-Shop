package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.models.AchievementsEvent
import com.ig81.igshop.models.AchievementsViewState
import com.ig81.igshop.models.uimodels.UserUiModel
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetIconButton
import com.ig81.igshop.ui.theme.components.JetTabButton
import com.microsoft.fluent.mobile.icons.R

@Composable
fun AchievementsViewScreen(
    viewState: AchievementsViewState.Display,
    dispatcher: (AchievementsEvent) -> Unit,

) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            JetIconButton(
                R.drawable.ic_fluent_chevron_left_16_filled,
                modifier = Modifier.size(48.dp),
                shape = MaterialTheme.shapes.small,
                contentPadding = PaddingValues(12.dp),
                onClick = { dispatcher.invoke(AchievementsEvent.CloseScreen) })
            Text(
                text = "Достижения",
                color = Color(0xFFCACACA),
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp)
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_fluent_people_search_24_regular),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(32.dp)
            )
        }
        Column(
            Modifier
                .weight(1f)
                .padding(top = 32.dp, bottom = 64.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.small
                )
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                JetTabButton(
                    "Покупатели",
                   isSelected =  (viewState.tabIndex == 0),
                    onClick = { dispatcher.invoke(AchievementsEvent.ChangeTab(0)) })

                JetTabButton(
                    "VIP-покупатели",
                    (viewState.tabIndex == 1),
                    onClick = { dispatcher.invoke(AchievementsEvent.ChangeTab(1)) })
            }
            if (viewState.tabIndex == 0) AchievementsWidget(
                viewState.regularCustomers,

                modifier = Modifier.padding(0.dp)
            )
            else {
                AchievementsWidget(viewState.vipCustomers)
            }


        }
        Button(
            onClick = {}, modifier = Modifier.fillMaxWidth(),


            border = BorderStroke(4.dp, color = Color(0xFF000000).copy(0.5f)),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color(0xFF000000).copy(0.5f),

                ), contentPadding = PaddingValues(18.dp)
        ) {
            Text(
                "Посмотреть весь список",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 16.sp)
            )
        }
    }
}


@Preview()
@Composable
fun AchievementsViewScreenPreview() {
    val viewState = AchievementsViewState.Display(
        regularCustomers = listOf(
          UserUiModel(1, imagePath = "path_to_image_1", name="User 1",balls= 150),
            UserUiModel(2,  imagePath ="path_to_image_2", name="User 2", balls=120),
            UserUiModel(3,  imagePath ="path_to_image_3", name="User 3",balls= 100),
            UserUiModel(4,  imagePath ="path_to_image_4", name="User 4", balls=180),
            UserUiModel(5,  imagePath ="path_to_image_5", name="User 5",balls= 160)
        ),
        vipCustomers = listOf(
            UserUiModel(1,  imagePath ="path_to_image_1",name= "Джонни Джонсон",balls= 150),
            UserUiModel(2,  imagePath ="path_to_image_2", name="Мэри Мэроу",balls= 120),
            UserUiModel(3,  imagePath ="path_to_image_3", name="Дики Дуо", balls=100),
            UserUiModel(4,  imagePath ="path_to_image_4", name="Рикки Ру", balls=180),
            UserUiModel(5,  imagePath ="path_to_image_5", name="Тин Тин", balls=160)
        ), tabIndex = 0
    )
    IGShopTheme {
        AchievementsViewScreen(
            viewState = viewState,
            dispatcher = { },

        )
    }
}