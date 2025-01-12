package com.ig81.igshop.ui.screens.home.views


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ig81.igshop.models.uimodels.SportCarUiModel
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetRatingBar

@Composable
fun SportCarCard(
    car: SportCarUiModel,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surface,
                MaterialTheme.shapes.medium
            )
            .let { if (onClick != null) it.clickable(onClick = onClick) else it }

            .padding(start = 16.dp, top = 16.dp, end = 18.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AsyncImage(
            model = car.imagePath,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 24.dp)

                .clip(MaterialTheme.shapes.medium)
                .size(64.dp, 64.dp)

        )

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Text(
                text = car.carName,
                color = Color(0xFFFFFFFF),
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 18.sp)
            )
            Text(
                text = car.carType,
                color = Color(0xFFEBEBEB),
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 13.sp)
            )
            Row(


                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                JetRatingBar(car.rating)
                Spacer(Modifier.weight(1f))
                Text(
                    text = "${car.price} Kr",
                    color = Color(0xFFEBEBEB),
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),


                    )
            }

        }
    }


}


@Composable
@Preview
fun SportCarCardPreview() {
    IGShopTheme {
        SportCarCard(
            car =SportCarUiModel(
                "Lamba-A",
                "Классический спорткар",
                177000,
                5,
                "file:///android_asset/Shop1.jpg"
            ), Modifier.fillMaxWidth()


        )
    }
}