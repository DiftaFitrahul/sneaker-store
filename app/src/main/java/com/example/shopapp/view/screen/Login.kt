package com.example.shopapp.view.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopapp.Greeting
import com.example.shopapp.R
import com.example.shopapp.ui.theme.Grey
import com.example.shopapp.ui.theme.LightGrey
import com.example.shopapp.ui.theme.ShopAppTheme
import com.example.shopapp.view.component.DefaultAppButton
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
            Divider(color = Color.Transparent, modifier = Modifier.height(50.dp))
            DefaultAppTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Email Address",
                isError = false,
                value = "",
                placeHolder = stringResource(id = R.string.placeholder_email),
                onValueChange = {},
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )
            DefaultAppTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Password",
                isSecureText = true,
                isError = false,
                value = "",
                placeHolder = stringResource(id = R.string.placeholder_password),
                onValueChange = {},
                trailingIcon = {
                    IconButton(

                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(end = 13.dp)
                            .size(20.dp)
                    ) {
                        Icon(
                            Icons.Default.Build, contentDescription = null,
                            tint = Grey.copy(alpha = 0.7f)

                        )
                    }
                }
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                TextButton(
                    onClick = { /*TODO*/ },

                    ) {
                    Text(
                        text = stringResource(id = R.string.label_recovery_password),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = LightGrey
                        )
                    )
                }
            }

            DefaultAppButton(
                text = stringResource(id = R.string.label_button_sign_in),
                onClick = { /*TODO*/ })

            Button(onClick = { /*TODO*/ }) {
                Row {

                }
            }

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