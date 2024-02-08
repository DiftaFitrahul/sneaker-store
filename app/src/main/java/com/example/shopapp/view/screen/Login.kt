package com.example.shopapp.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopapp.Greeting
import com.example.shopapp.ui.theme.ShopAppTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize().padding(top = 70.dp),

            horizontalAlignment = Alignment.CenterHorizontally

            ) {
            Text(text = "Halo bang")

        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShopAppTheme {
        LoginScreen()
    }
}