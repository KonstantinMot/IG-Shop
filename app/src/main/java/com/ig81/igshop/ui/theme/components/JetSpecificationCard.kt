package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun JetSpecificationCard(modifier: Modifier = Modifier, specification: List<String>) {
    Box(
        modifier = modifier
            .size(346.dp, 149.dp)
            .background(
                MaterialTheme.colorScheme.surface.copy(0.1f),
                shape = RoundedCornerShape(
                    topStart = 60.dp,
                    topEnd = 60.dp,
                    bottomStart = 32.dp,
                    bottomEnd = 32.dp
                )
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = "Спецификации",
            color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier
                .align(Alignment.TopCenter)
                .padding(10.dp)
        )
        Box(
            modifier = Modifier
                .size(315.dp, 112.dp)
                .background(
                    MaterialTheme.colorScheme.surface.copy(0.1f),
                    shape = RoundedCornerShape(
                        topStart = 56.dp,
                        topEnd = 56.dp,
                        bottomEnd = 16.dp,
                        bottomStart = 16.dp
                    )
                ),
            contentAlignment = Alignment.BottomCenter

        ) {
            Row(
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()


            ) {
                specification.forEach { specification ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier
                            .padding(17.dp)

                    ) {
                        Text(
                            text = specification,
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(0.dp))

                        JetCircularRatingBar(modifier = Modifier, 4)

                    }
                }
            }


        }

    }


}


@Preview
@Composable
fun JetSpecificationCardPreview() {
    IGShopTheme {
        Box(
            modifier = Modifier
                .size(346.dp, 149.dp)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            JetSpecificationCard(
                modifier = Modifier,
                specification = listOf("Скорость", "Корпус", "Щиты")
            )
        }
    }
}