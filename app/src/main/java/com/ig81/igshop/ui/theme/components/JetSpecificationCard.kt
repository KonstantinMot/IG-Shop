package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.models.uimodels.SpecificationUiModel
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun JetSpecificationCard(specification: List<SpecificationUiModel>, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFFFFFFF).copy(0.1f),
                shape = RoundedCornerShape(
                    topStart = 60.dp,
                    topEnd = 60.dp,
                    bottomStart = 32.dp,
                    bottomEnd = 32.dp
                )
            ),
        contentAlignment = Alignment.BottomCenter,

        ) {
        Text(
            text = "Спецификации",
            color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp),
            modifier = modifier
                .align(Alignment.TopCenter)
                .padding(top = 12.dp)

        )

        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            modifier = Modifier
                .padding(end = 15.dp, top = 37.dp, start = 15.dp)
                .fillMaxWidth()
                .background(
                    Color(0xFFFFFFFF).copy(0.1f), shape = RoundedCornerShape(
                        topStart = 56.dp,
                        topEnd = 56.dp,
                        bottomEnd = 16.dp,
                        bottomStart = 16.dp
                    )
                )


        ) {
            specification.forEach { (name, rating) ->
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 41.dp, end = 16.dp, bottom = 17.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp),


                    ) {
                    Text(
                        text = name,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp)
                    )


                    JetCircularRatingBar(modifier = Modifier, rating = rating)


                }
            }


        }

    }


}


@Preview(
    showBackground = true,
    backgroundColor = 0xFF2E4552
)
@Composable
fun JetSpecificationCardPreview() {
    IGShopTheme {


        JetSpecificationCard(
            modifier = Modifier,
            specification = listOf(
                SpecificationUiModel("скорость", 2),
                SpecificationUiModel("щит", 4),
                SpecificationUiModel("ходовая", 5)))

    }
}