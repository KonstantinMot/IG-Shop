package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.microsoft.fluent.mobile.icons.R

@Composable
fun JetRatingBar(rating: Int, modifier: Modifier = Modifier,sizeStar: Dp =16.dp) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        (0..4).forEach() {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_fluent_star_16_filled),
                contentDescription = null,
                tint = if (it < rating) {
                    Color(0xFFFFBD13)
                } else {
                    Color(0xFFCACACA)
                },
                modifier = Modifier.size(sizeStar)
                    .aspectRatio(1f)

            )


        }
    }


}


@Preview(
    showBackground = true,
    backgroundColor = 0xFF4D616C
)
@Composable
fun JetRatingBarPreview() {
    IGShopTheme { JetRatingBar(4) }
}



