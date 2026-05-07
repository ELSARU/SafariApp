package com.victor.safariwalk.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.victor.safariwalk.ui.screens.authentication.ForgotPasswordScreen
import com.victor.safariwalk.ui.screens.authentication.LoginScreen
import com.victor.safariwalk.ui.screens.authentication.OnboardingScreen
import com.victor.safariwalk.ui.screens.authentication.RegisterScreen
import com.victor.safariwalk.ui.screens.authentication.SignUpScreen
import com.victor.safariwalk.ui.screens.authentication.ProfileScreen
import com.victor.safariwalk.ui.screens.messages.MessageScreen


@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier){
    NavHost(
          navController = navController,
        startDestination = ROUTES.Login.name) {
        composable(ROUTES.Onboarding.name) { OnboardingScreen(navController,modifier)}
        composable(ROUTES.Login.name){ LoginScreen(navController,modifier) }
        composable ( ROUTES.signup.name) { SignUpScreen(navController,modifier) }
        composable(ROUTES.ForgotPassword.name){ ForgotPasswordScreen(navController,modifier) }
        composable(ROUTES.Register.name){ RegisterScreen(navController,modifier) }
        composable(ROUTES.Home.name){ }
        composable(ROUTES.profile.name){ ProfileScreen(navController,modifier) }
        composable(ROUTES.Messages.name){ MessageScreen(modifier = modifier) }
    }
}