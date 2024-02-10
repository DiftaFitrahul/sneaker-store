package com.example.shopapp.view.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopapp.ui.theme.LightGrey

@Composable
fun DefaultAppBackButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = LightGrey.copy(
                alpha = 0.1f
            )
        ),
        modifier = modifier.size(45.dp)

    ) {
        Icon(
            Icons.Default.KeyboardArrowLeft,
            contentDescription = Icons.Default.KeyboardArrowLeft.name
        )
    }
}