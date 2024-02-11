package com.example.shopapp.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.R
import com.example.shopapp.ui.theme.LightGrey
import com.example.shopapp.ui.theme.Raleway
import com.example.shopapp.view.component.DefaultAppBackButton
import com.example.shopapp.view.component.DefaultAppButton

@Preview
@Composable
fun OTPVerificationScreen(modifier: Modifier = Modifier, onBackButton: () -> Unit = {}) {
    var otpText by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, top = 18.dp), contentAlignment = Alignment.CenterStart
            ) {
                DefaultAppBackButton(onClick = onBackButton)
            }
        },

        modifier = modifier.fillMaxSize()
    ) {
        val focusManager = LocalFocusManager.current
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(top = 10.dp, start = 18.dp, end = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.title_OTP_verification_page),
                style = MaterialTheme.typography.headlineLarge

            )
            Divider(modifier = Modifier.height(5.dp), color = Color.Transparent)
            Text(
                text = stringResource(id = R.string.subtitle_OTP_verification_page),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = LightGrey
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = stringResource(id = R.string.label_OTP_code_field),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 21.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            OTPField(otpText = otpText, onValueChange = { newText ->
                if (newText.length <= 4) {
                    otpText = newText
                    if (otpText.length == 4) {
                        focusManager.clearFocus()
                    }
                }
            })
            Spacer(modifier = Modifier.height(45.dp))
            DefaultAppButton(
                text = stringResource(id = R.string.label_button_OTP_verification_page),
                onClick = { /*TODO*/ })
            Spacer(modifier = Modifier.height(7.dp))
            Row(
                modifier=Modifier.fillMaxWidth().padding(horizontal = 7.dp),
horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    stringResource(id = R.string.label_resend_code),

                   style = TextStyle(
                       fontSize = 12.sp,
                       fontFamily = Raleway,
                       fontWeight = FontWeight.Normal,
                       color = LightGrey
                   ),

                    modifier = Modifier
                        .clickable {
                            // onClick()
                        }
                )
                Text(text = "00:30", style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = Raleway,
                    fontWeight = FontWeight.Normal,
                    color = LightGrey
                ),)
            }

        }
    }
}

@Composable
fun OTPField(
    otpText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BasicTextField(
        value = otpText, onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(4) { index ->
                val number = when {
                    index >= otpText.length -> ""
                    else -> otpText[index]
                }

                Box(
                    modifier = Modifier
                        .width(76.dp)
                        .height(56.dp)
                        .clip(
                            RoundedCornerShape(12.dp)
                        )

                        .background(LightGrey.copy(alpha = 0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = number.toString(), style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }
    }
}