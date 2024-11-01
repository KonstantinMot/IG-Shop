package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.ig81.igshop.ui.theme.IGShopTheme
import com.microsoft.fluent.mobile.icons.R

@Composable
fun JetCircularRatingBar(modifier: Modifier = Modifier, rating: Int) {

        Box(
            modifier = modifier


                .size(56.dp,54.dp),

            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .size(47.dp)
                    .border(6.325.dp, Color(0xFF869197), shape = CircleShape)
            )

            for (i in 0..4) {

                val starColorBig =
                    if (i < rating) {
                        Color(0xFFFFBD13)
                    } else {
                        Color(0xFF869197)
                    }
                val starColorSmall =
                    if (i < rating) {
                        Color(0xFFFFBD13)
                    } else {
                        Color(0xFF556772)
                    }
                val starModifier = when (i) {
                    0 -> {
                        Modifier
                            .size(16.dp)
                            .align(Alignment.TopCenter)
                            .offset(x=0.dp,y=(-2).dp)
                    }

                    1 -> {
                        Modifier
                            .size(16.dp)
                            .align(Alignment.CenterEnd)
                            .offset(x = (0).dp, y = (-5).dp)
                    }

                    2 -> {
                        Modifier
                            .size(16.dp)
                            .align(Alignment.BottomEnd)
                            .offset(x = (-9).dp, y = (-3).dp)
                    }

                    3 -> {
                        Modifier
                            .size(16.dp)
                            .align(Alignment.BottomStart)
                            .offset(x = (9).dp, y = (-3).dp)
                    }

                    else -> {
                        Modifier
                            .size(16.dp)
                            .align(Alignment.CenterStart)
                            .offset(x = 0.dp, y = (-5).dp)
                    }
                }
                StrokeIcon(starModifier, starColorBig, starColorSmall)
            }
            Text(
                text = rating.toString(),
                color = MaterialTheme.colorScheme.surface,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }


@Preview
@Composable
fun JetCircularRatingBarPreview() {
    IGShopTheme { JetCircularRatingBar(modifier = Modifier, 3) }
}

@Composable
private fun StrokeIcon(modifier: Modifier=Modifier, tintBig: Color, tintSmall: Color) {

    Box(
        modifier = modifier.size(16.dp)
    ) {

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_fluent_star_24_filled),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.Center),
            tint = tintBig
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_fluent_star_24_filled),
            contentDescription = null,
            modifier = Modifier
                .size(14.dp)
                .align(Alignment.Center),
            tint = tintSmall
        )
    }
}

