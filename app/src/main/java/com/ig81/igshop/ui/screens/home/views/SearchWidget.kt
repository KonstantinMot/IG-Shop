package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetSearchTextField
import com.ig81.igshop.ui.theme.jetShape
import com.microsoft.fluent.mobile.icons.R

@Composable
fun SearchWidget(
    values: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "Поиск"
) {
    Row(
        modifier = modifier
            .clip(jetShape.small)
            .background(
                MaterialTheme.colorScheme.surface
            )
            ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_fluent_chevron_left_24_filled),
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(20.dp)
            )

        }
        VerticalDivider( Modifier.height(24.dp).width(1.dp), color = Color(0xFFE2E2EA))

        JetSearchTextField(value = values, onValueChange = onValueChange, hint = hint, modifier = modifier.weight(1f))


    }

}


@Preview
@Composable
fun SearchWidgetPreview() {
    IGShopTheme { SearchWidget(values = "Lamba ", onValueChange = {}, onClick = {}) }
}