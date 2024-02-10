package com.example.shopapp.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.R
import com.example.shopapp.ui.theme.Grey
import com.example.shopapp.ui.theme.LightGrey
import com.example.shopapp.view.component.DefaultAppBackButton
import com.example.shopapp.view.component.DefaultAppButton
import com.example.shopapp.view.component.DefaultAppTextField

@Preview
@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Box (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, top = 18.dp), contentAlignment = Alignment.CenterStart){
                DefaultAppBackButton (onClick = {})
            }
        },
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 10.dp, start = 18.dp, end = 18.dp)

        ) {

            Text(
                text = stringResource(id = R.string.title_sign_up),
                style = MaterialTheme.typography.headlineLarge
            )
            Divider(modifier = Modifier.height(5.dp), color = Color.Transparent)
            Text(
                text = stringResource(id = R.string.subtitle_auth),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = LightGrey
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            Divider(color = Color.Transparent, modifier = Modifier.height(15.dp))
            DefaultAppTextField(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.label_name_auth_field),
                isError = false,
                value = "",
                placeHolder = stringResource(id = R.string.placeholder_name),
                onValueChange = {},
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )
            Divider(
                color = Color.Transparent,
                modifier = Modifier.height(20.dp)
            )
            DefaultAppTextField(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.label_email_auth_field),
                isError = false,
                value = "",
                placeHolder = stringResource(id = R.string.placeholder_email),
                onValueChange = {},
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )
            Divider(
                color = Color.Transparent,
                modifier = Modifier.height(20.dp)
            )
            DefaultAppTextField(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.label_password_auth_field),
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
            Divider(
                color = Color.Transparent,
                modifier = Modifier.height(10.dp)
            )
            DefaultAppButton(
                text = stringResource(id = R.string.label_button_sign_up),
                onClick = { /*TODO*/ })
            Divider(color = Color.Transparent, modifier = Modifier.height(24.dp))
            SignInWithGoogle(onClick = {})

            Divider(
                color = Color.Transparent,
                modifier = Modifier.weight(1f)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .fillMaxWidth()

            ) {
                Text(
                    text = "${stringResource(id = R.string.label_already_have_account)} ",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightGrey
                    ),
                    softWrap = true
                )
                ClickableText(
                    text = AnnotatedString(text = stringResource(id = R.string.label_login)),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,

                        ),
                    onClick = {

                    })
            }

        }
    }
}