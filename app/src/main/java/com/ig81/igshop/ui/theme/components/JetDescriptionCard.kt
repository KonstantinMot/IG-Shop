package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun JetDescriptionCard(description: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFFFFFFF).copy(0.1f),
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp,
                    bottomStart = 60.dp,
                    bottomEnd = 60.dp
                )
            ),
        contentAlignment = Alignment.BottomCenter,

        ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp,end=16.dp, bottom = 37.dp)
                .fillMaxWidth()
                .background(
                    Color(0xFFFFFFFF).copy(0.1f), shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomEnd = 56.dp,
                        bottomStart = 56.dp
                    )
                ), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Описание",
                color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp),
                modifier = modifier.padding(top=12.dp)
            )
            Text(text = description,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 14.sp, fontSize = 12.sp),
                textAlign = TextAlign.Center ,
                modifier = modifier.padding(start = 36.dp,top =7.dp,end=36.dp, bottom = 23.dp))


        }

    }


}


@Preview(
    showBackground = true,
    backgroundColor = 0xFF2E4552
)
@Composable
private fun JetDescriptionCardPreview() {
    IGShopTheme {
        JetDescriptionCard(
            "Лучший спорткар на всём Внешнем кольце." +
                    " Его модернезированные версии завоевывают первые " +
                    "места на всех крупных соревнованиях в галактике!"
        )
    }
}