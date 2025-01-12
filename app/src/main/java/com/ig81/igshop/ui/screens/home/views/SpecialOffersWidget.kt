package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.R
import com.ig81.igshop.models.uimodels.OfferPreviewUiModel
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.jetShape

@Composable
fun SpecialOffersWidget(specialOffers:List<OfferPreviewUiModel>,modifier: Modifier=Modifier,onClick:(()->Unit)?=null) {
    val offerNumber = specialOffers.reversed()

    Column(modifier=modifier.padding(horizontal = 32.dp)) {
        Text(
            text = stringResource(R.string.special_offers_title),
            color = Color(0xFFCACACA),
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 18.sp),
            modifier = Modifier
        )
        LazyRow(
            Modifier.padding(top = 8.dp)
                .clip(jetShape.dialog)
                .clickable{onClick?.invoke()},
            horizontalArrangement = Arrangement.spacedBy((-160).dp),
            reverseLayout = true
        ) {
            itemsIndexed(offerNumber) { index, number ->
                val alpha = (1f - ((offerNumber.size - 1 - index) * 0.30f)).coerceIn(0f, 1f)
                val backgroundColor = MaterialTheme.colorScheme.surface.copy(alpha = alpha)
                SpecialOfferCard(
                    number = number.number,
                    selected = index == offerNumber.lastIndex,
                    modifier = Modifier.background(backgroundColor, jetShape.dialog)
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
fun SpecialOffersWidgetPreview() {
    IGShopTheme { SpecialOffersWidget(specialOffers =listOf(
       OfferPreviewUiModel( "103 436"),
        OfferPreviewUiModel("105 423"),
        OfferPreviewUiModel("121 453"),
        OfferPreviewUiModel("364 154")))
    }

}