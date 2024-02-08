package com.example.shopapp.view.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.ui.theme.Blue
import com.example.shopapp.ui.theme.ShopAppTheme


@Composable
fun DefaultAppButton(
    text: String,
    onClick: () -> Unit,
    modifier : Modifier = Modifier
) {
    ElevatedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 0.dp
        ),
        shape = RoundedCornerShape(
            14.dp
        ),
        modifier = modifier.fillMaxWidth()

    ) {
        Text(text = text, style = MaterialTheme.typography.headlineSmall.copy(
            fontSize = 14.sp
        ),
        modifier = Modifier.padding(vertical = 10.dp)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShopAppTheme {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            DefaultAppButton(text = "Halo", onClick = {})
        }
    }
}