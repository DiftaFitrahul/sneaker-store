package com.example.shopapp.utils.route

sealed class Screen(val route:String) {
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object RecoverPasswordScreen : Screen("recover_password_screen")
}

