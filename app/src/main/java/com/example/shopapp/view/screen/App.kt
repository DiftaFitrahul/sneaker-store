package com.example.shopapp.view.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shopapp.utils.route.Screen


@Composable
fun MainApp(navController: NavHostController = rememberNavController()) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentState = backStackEntry?.destination?.route ?: Screen.LoginScreen.route

    val isAuthenticated = false


    NavHost(
        navController = navController,
        startDestination = if (isAuthenticated) Screen.RegisterScreen.route else Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(
                onRecoverPassword = {
                    navController.navigate(route = Screen.RecoverPasswordScreen.route)
                },
                onCreateNewAccount = {
                    navController.navigate(route = Screen.RegisterScreen.route)
                })
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(
                onBackButton = {
                    navController.popBackStack()
                },
                onLoginAccount = {

                    navController.navigate(route = Screen.LoginScreen.route)

                })
        }
        composable(route = Screen.RecoverPasswordScreen.route) {
            RecoverPassword(
                onBackButton = {
                    navController.popBackStack()

                }
            )
        }
    }
}