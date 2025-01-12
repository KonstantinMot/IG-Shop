package com.ig81.igshop.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ig81.igshop.R

val font= FontFamily(
    Font(resId = R.font.roboto_regular, weight = FontWeight.Normal),
    Font(resId = R.font.roboto_medium, weight = FontWeight.Medium),
    Font(resId = R.font.roboto_light, weight = FontWeight.Light),
    Font(resId = R.font.roboto_bold, weight = FontWeight.Bold)
)
// Set of Material typography styles to start with


val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal, // Использует Roboto Regular
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Medium, // Использует Roboto Medium
        fontSize = 14.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Light, // Использует Roboto Light
        fontSize = 14.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Bold, // Использует Roboto Bold
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )

)


