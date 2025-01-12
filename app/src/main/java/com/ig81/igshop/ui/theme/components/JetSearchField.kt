package com.ig81.igshop.ui.theme.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.utils.advancedShadow
import com.microsoft.fluent.mobile.icons.R

@Composable
fun JetSearchField(hint: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier


            .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.small)
            .advancedShadow(color = Color(0x00000000), 0.02f, 0.dp, 4.dp, 5.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector =
            ImageVector.vectorResource(R.drawable.ic_fluent_search_48_regular),
            contentDescription = null,
            tint = Color(0xFFFFFFFF),
           modifier =  Modifier.padding(12.dp)
               .size(24.dp)
        )

        Text(
            text = value.ifEmpty { hint },
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp),
            modifier = Modifier.padding(start = 5.dp, end = 17.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun JetSearchFieldPreview() {
    IGShopTheme { JetSearchField("Найти спорткар ...", "") }
}