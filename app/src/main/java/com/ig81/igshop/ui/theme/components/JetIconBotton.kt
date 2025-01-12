package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.microsoft.fluent.mobile.icons.R

@Composable
fun JetIconButton(
    vectorDrawableId: Int,
    modifier: Modifier,
    shape: CornerBasedShape,
    contentPadding: PaddingValues,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(Color(0xFFA5A5A5).copy(0.1f), shape)
            .clip(shape)
            .clickable(onClick = onClick)
            .padding(contentPadding)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(vectorDrawableId),
            contentDescription = null,
            tint = Color(0xFFA5A5A5),
            modifier = Modifier.fillMaxSize()
        )

    }


}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF2E4552
)
@Composable
fun JetIconButtonPreview() {
    IGShopTheme {
        JetIconButton(
            R.drawable.ic_fluent_chevron_left_16_filled,
            modifier = Modifier.size(48.dp),
            shape = MaterialTheme.shapes.small,
            contentPadding = PaddingValues(12.dp), onClick = { println("Back") }
        )
    }
}