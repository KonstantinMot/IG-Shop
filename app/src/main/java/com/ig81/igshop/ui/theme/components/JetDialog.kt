package com.ig81.igshop.ui.theme.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.jetShape

import com.microsoft.fluent.mobile.icons.R


@Composable
fun JetDialog(title: String, body: String, buttonText: String, icon: Int, onClose: () -> Unit) {

    Dialog(onDismissRequest = onClose) { DialogContent(title, body, buttonText, icon, onClose) }
}


@Composable
private fun DialogContent(
    title: String,
    body: String,
    buttonText: String,
    icon: Int,
    onClose: () -> Unit
) {
    Box(
        Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter
    ) {
        Column(
            Modifier
                .padding(top = 27.dp)
                .clip(jetShape.dialog)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                color = Color(0xFFFFFFFF),
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 16.sp),
                modifier = Modifier.padding(top = 32.dp, bottom = 8.dp)
            )
            Text(
                text = body,
                color = Color(0xFFFFFFFF),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 14.sp,
                    lineHeight = 17.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 20.dp)

            )
            Box(
                Modifier
                    .padding(top = 29.dp)

                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                TextButton(
                    onClose,
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    Text(
                        text = buttonText,
                        color = MaterialTheme.colorScheme.background,
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 16.sp)
                    )

                }
            }
        }

        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(52.dp)
                .background(MaterialTheme.colorScheme.background, shape = CircleShape)
                .padding(8.dp)

        )
    }
}

@Preview
@Composable
fun JetDialogPreview() {
    IGShopTheme {
        JetDialog(
            "Ошибка",
            "Проверьте подключение к сети Интернет",
            "ОК",
            R.drawable.ic_fluent_wifi_off_24_regular, onClose = {}
        )
    }
}
