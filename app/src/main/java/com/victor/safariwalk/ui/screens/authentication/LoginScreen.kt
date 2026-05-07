package com.victor.safariwalk.ui.screens.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.victor.safariwalk.R
import com.victor.safariwalk.ui.navigation.ROUTES
import com.victor.safariwalk.ui.theme.primaryColor
import com.victor.safariwalk.ui.theme.secondaryColor
import com.victor.safariwalk.ui.theme.tertiaryColor


@Composable
fun LoginScreen(navController: NavHostController,modifier: Modifier) {
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordInput by remember { mutableStateOf(TextFieldValue("")) }



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    )

    {
        // lottie animation

        LottieAnimationWidget()

        Spacer(modifier = Modifier.height(20.dp))

        //Welcome message
        Text(
            text = "Login to SafariWalk!!",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold


            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        //email input
        OutlinedTextField(
            value = emailInput,
            onValueChange = { emailInput = it },
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.outline_stacked_email_24),
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = secondaryColor,
                unfocusedBorderColor = primaryColor
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))
//password input
        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.outline_visibility_off_24),
                    contentDescription = "Password",
                    tint = secondaryColor
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = secondaryColor,
                unfocusedBorderColor = tertiaryColor
            )


        )


        //Button

        OutlinedButton(onClick = { navController.navigate(ROUTES.Onboarding.name) }) {
            Text(
                text = "Login"
            )
        }


    }
}










@Composable
fun LottieAnimationWidget() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.login))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever

    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(250.dp)
    )
}

@Composable

fun LoginButton(){

    OutlinedButton(onClick = {}) {
        Text(
            text = "Login",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = tertiaryColor
            )
        )

    }
}

