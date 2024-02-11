package com.example.shopapp.utils.route

sealed class Screen(val route:String) {
    data object LoginScreen : Screen("login_screen")
    data object RegisterScreen : Screen("register_screen")
    data object RecoverPasswordScreen : Screen("recover_password_screen")
    data object OTPVerificationScreen : Screen("otp_verification_screen")
}

