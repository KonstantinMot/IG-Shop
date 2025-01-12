package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.models.uimodels.UserUiModel
import com.ig81.igshop.ui.theme.IGShopTheme
import com.microsoft.fluent.mobile.icons.R


@Composable
fun AchievementsWidget(
    topCustomers: List<UserUiModel>,
    modifier: Modifier=Modifier,
    title: String? = null,
    icon: Int? = null,
    onClick: (() -> Unit)? = null,


) {
    Column(modifier=modifier) {
        if (title != null || icon != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                title?.let {
                    Text(
                        text = it,
                        color = Color(0xFFCACACA),
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 18.sp),
                        modifier = Modifier.weight(1f)
                    )
                }
                icon?.let {
                    IconButton(onClick = { println("") }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(it),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }
        Column(
           modifier =  Modifier
                .background(
                    MaterialTheme.colorScheme.surface, MaterialTheme.shapes.small

                )
                .clip(MaterialTheme.shapes.small)
                .let { if (onClick != null) it.clickable(onClick = onClick) else it }
                .padding(start = 12.dp, top = 18.dp, end = 25.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            topCustomers.forEachIndexed { index, user ->
                UserRatingCard(user = user.copy(rankNumber = index + 1))
                HorizontalDivider(thickness = 2.dp, color = Color(0xFFFFFFFF).copy(0.25f))
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0x2E4552
)
@Composable
fun AchievementsWidgetPreview() {
    IGShopTheme {
        AchievementsWidget(
            topCustomers = listOf(
                UserUiModel(1,  "User 1", 150),
                UserUiModel(2,  "User 2", 120),
                UserUiModel(3,  "User 3", 100),
                UserUiModel(4,  "User 4", 180),
                UserUiModel(5,  "User 5", 160)
            ),
            title =
            stringResource(com.ig81.igshop.R.string.achievements_and_awards_title),
            icon = R.drawable.ic_fluent_filter_24_filled
        )
    }
}
