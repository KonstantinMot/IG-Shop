package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.jetShape
import com.ig81.igshop.utils.dashedBorder
import com.microsoft.fluent.mobile.icons.R

@Composable
fun SpecialOfferCard(number: String, selected: Boolean, modifier: Modifier = Modifier) {
    val border = if (selected) {
        modifier.border(2.dp, MaterialTheme.colorScheme.secondary, jetShape.dialog)
    } else {
        modifier.dashedBorder(
            2.dp,
            MaterialTheme.colorScheme.secondary,
            jetShape.dialog,
            10.dp,
            10.dp
        )
    }

    Box(
        modifier = modifier.padding()
//            .background(MaterialTheme.colorScheme.surface, jetShape.dialog)
            .then(border)
            .padding(start = 16.dp, top = 14.dp, end = 9.dp, bottom = 15.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_fluent_contact_card_32_filled),
            contentDescription = null,
            tint = Color(0xFFFFFFFF).copy(0.50f),
            modifier = Modifier
                .padding(end = 85.dp)
                .size(96.dp,96.dp)

                .align(alignment = Alignment.CenterStart)
        )

        Text(
            text = "№ $number",
            color = Color(0xFFFFFFFF).copy(0.75f),
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .graphicsLayer {
                    rotationZ = -90f
                    translationX = 22.dp.toPx()
                    translationY = 0f
                })
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0x2E4552
)
@Composable
fun SpecialOfferCardPreview() {
    IGShopTheme { SpecialOfferCard("103436", true,) }
}