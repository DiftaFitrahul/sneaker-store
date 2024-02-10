package com.example.shopapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.shopapp.R

val Poppins = FontFamily(
    Font(R.font.poppins_regular)
)

val Raleway = FontFamily(
    Font(R.font.raleway_bold, FontWeight.Bold),
    Font(R.font.raleway_semibold, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = Raleway,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Raleway,
        fontWeight = FontWeight.SemiBold,
        fontSize = 26.sp,
    ),
    headlineSmall =    TextStyle(
        fontFamily = Raleway,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)