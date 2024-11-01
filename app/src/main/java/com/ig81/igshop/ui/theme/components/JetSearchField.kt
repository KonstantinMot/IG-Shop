package com.ig81.igshop.ui.theme.components


import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.utils.advancedShadow

@Composable
fun JetSearchField(hint: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth( )
            .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.small)
            .advancedShadow(color = Color(0x00000000), 0.02f, 0.dp, 4.dp, 5.dp, 0.dp)
    ) { Text(text="ffff") }
}


@Preview(showBackground = true)
@Composable
fun JetSearchFieldPreview() {
    IGShopTheme { JetSearchField("Найти спорткар ...", "") }
}