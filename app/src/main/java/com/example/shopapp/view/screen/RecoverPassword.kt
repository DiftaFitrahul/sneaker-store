package com.example.shopapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.shopapp.R
import com.example.shopapp.ui.theme.Blue
import com.example.shopapp.ui.theme.LightGrey
import com.example.shopapp.view.component.DefaultAppBackButton
import com.example.shopapp.view.component.DefaultAppButton
import com.example.shopapp.view.component.DefaultAppTextField

@Preview
@Composable
fun RecoverPassword(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Box (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, top = 18.dp), contentAlignment = Alignment.CenterStart){
                DefaultAppBackButton (onClick = {})}
        },
        modifier = modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(top = 10.dp, start = 18.dp, end = 18.dp)
        ) {
            Text(
                text = stringResource(id = R.string.title_recover_page),
                style = MaterialTheme.typography.headlineLarge

            )
            Divider(modifier = Modifier.height(5.dp), color = Color.Transparent)
            Text(
                text = stringResource(id = R.string.subtitle_recover_page),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = LightGrey
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp)
            )

            DefaultAppTextField(
                modifier = Modifier.fillMaxWidth(),
                isError = false,
                value = "",
                placeHolder = stringResource(id = R.string.placeholder_name),
                onValueChange = {},
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(50.dp))
            DefaultAppButton(
                text = stringResource(id = R.string.label_button_sign_in),
                onClick = { /*TODO*/ })
            DialogResult()
        }
    }
}

@Composable
fun DialogResult(modifier: Modifier = Modifier){
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Box (
            modifier = modifier
                .clip(shape = RoundedCornerShape(12))
                .background(Color.White)
                .padding(horizontal = 25.dp, vertical = 16.dp),
            contentAlignment = Alignment.Center
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(top=10.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Blue)
                        .padding(10.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.email), contentDescription = Icons.Default.Email.name,
                    modifier = Modifier.size(25.dp)
                    )


                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = stringResource(id = R.string.title_dialog_recover_page), style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ))
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = stringResource(id = R.string.subtitle_dialog_recover_page), style = MaterialTheme.typography.bodyLarge.copy(
                    color = LightGrey,
                    lineHeight = 19.sp
                ), textAlign = TextAlign.Center)

            }
        }
    }
}