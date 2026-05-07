package com.victor.safariwalk.ui.screens.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.victor.safariwalk.R
import com.victor.safariwalk.ui.theme.primaryColor
import com.victor.safariwalk.ui.theme.secondaryColor
import com.victor.safariwalk.ui.theme.tertiaryColor

@Composable
fun SignUpScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordInput by remember { mutableStateOf(TextFieldValue("")) }
    var fullNameInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Sign Up for SafariWalk!!",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Full Name input
        OutlinedTextField(
            value = fullNameInput,
            onValueChange = { fullNameInput = it },
            label = { Text("Full Name") },
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = secondaryColor,
                unfocusedBorderColor = primaryColor
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // email input
        OutlinedTextField(
            value = emailInput,
            onValueChange = { emailInput = it },
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.outline_stacked_email_24),
                    contentDescription = null
                )
            },
            label = { Text("Email Address") },
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = secondaryColor,
                unfocusedBorderColor = primaryColor
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // password input
        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.outline_password_24),
                    contentDescription = "Password Icon",
                    tint = secondaryColor
                )
            },
            trailingIcon = {
                val image = if (passwordVisible)
                    ImageVector.vectorResource(R.drawable.baseline_visibility_24)
                else ImageVector.vectorResource(R.drawable.outline_visibility_off_24)

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = description, tint = secondaryColor)
                }
            },
            label = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = secondaryColor,
                unfocusedBorderColor = tertiaryColor
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))

        // SignUp Button
        androidx.compose.material3.Button(
            onClick = { /* TODO: Sign Up logic */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = "Sign Up", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        androidx.compose.material3.TextButton(onClick = { navController.popBackStack() }) {
            Text(text = "Already have an account?")
        }
    }
}





