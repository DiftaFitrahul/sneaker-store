package com.example.shopapp.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopapp.Greeting
import com.example.shopapp.R
import com.example.shopapp.ui.theme.LightGrey
import com.example.shopapp.ui.theme.ShopAppTheme
import com.example.shopapp.view.component.DefaultAppTextField

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(top = 70.dp),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = stringResource(id = R.string.title_sign_in),
                style = MaterialTheme.typography.headlineLarge
            )
            Divider(modifier = Modifier.height(10.dp), color = Color.Transparent)
            Text(
                text = stringResource(id = R.string.subtitle_auth),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = LightGrey
                )
            )
            Divider(color= Color.Transparent, modifier = Modifier.height(50.dp))
            DefaultAppTextField(
                modifier = Modifier.fillMaxWidth(),
                label= "Email Address",
                isError = false,
                value = "",
                placeHolder = stringResource(id = R.string.placeholder_email),
                onValueChange = {}
            )
            DefaultAppTextField(
                modifier = Modifier.fillMaxWidth(),
                label= "Email Address",
                isError = false,
                value = "",
                placeHolder = stringResource(id = R.string.placeholder_email),
                onValueChange = {}
            )

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