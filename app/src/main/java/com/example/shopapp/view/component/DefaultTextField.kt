package com.example.shopapp.view.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.ui.theme.Grey
import com.example.shopapp.ui.theme.LightGrey
import com.example.shopapp.ui.theme.ShopAppTheme

@Composable
fun DefaultAppTextField(
    modifier: Modifier = Modifier,
    label: String = "",
    value: String,
    isSecureText: Boolean = false,
    placeHolder: String = "",
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    trailingIcon: @Composable() (() -> Unit)? = null,
    keyboardActions: KeyboardActions = KeyboardActions { },
    keyboardOptions: KeyboardOptions = KeyboardOptions()

) {
    Column {
        Text(
            text = label, style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 16.sp, fontWeight = FontWeight.Medium
            ), modifier = Modifier.padding(start = 5.dp, bottom = 12.dp)
        )
        TextField(
            modifier = modifier,
            value = value,
            isError = isError,
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp, color = Color.Black
            ),
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeHolder, style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp, color = Grey.copy(
                            alpha = 0.7f
                        )
                    )
                )
            },

            shape = RoundedCornerShape(14.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = LightGrey.copy(
                    alpha = 0.1f
                ),
                unfocusedContainerColor = LightGrey.copy(
                    alpha = 0.1f
                ),
                focusedTextColor = Color.Transparent,
                unfocusedTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            visualTransformation = if (isSecureText) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = trailingIcon,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions

        )
        AnimatedVisibility(
            visible = isError, enter = fadeIn(animationSpec = tween(2000))
        ) {
            Text(
                text = "please fill!!",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 12.sp, color = Color.Red.copy(
                        alpha = 0.6f
                    ), fontWeight = FontWeight.Medium
                ),
            )
        }
    }
}

