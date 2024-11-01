package com.ig81.igshop.ui.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

data class JetShape(
    val small : CornerBasedShape,
    val medium : CornerBasedShape,
    val large : CornerBasedShape,
    val  dialog : CornerBasedShape
)

val jetShape = JetShape(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(16.dp),
    dialog = RoundedCornerShape(24.dp)
)