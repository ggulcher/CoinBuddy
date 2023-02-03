package com.example.coinbuddy.ui.coindetail.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DetailButton(
    modifier: Modifier,
    icon: ImageVector,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .padding(4.dp)
            .border(
                border = ButtonDefaults.outlinedBorder,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(8.dp),
        onClick = { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
        )
    }
}
