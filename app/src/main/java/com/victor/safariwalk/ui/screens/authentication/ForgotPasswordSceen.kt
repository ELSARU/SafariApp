package com.victor.safariwalk.ui.screens.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.victor.safariwalk.ui.navigation.ROUTES



@Composable
fun ForgotPasswordScreen(navController: NavController,modifier: Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ){
    OutlinedButton(
        onClick = {
            navController.navigate(ROUTES.Login.name)
        }
    ) {
        Text(
            text = " ForgotPassword!)"
        )


    }  }}