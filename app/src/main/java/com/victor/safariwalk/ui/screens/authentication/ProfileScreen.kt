package com.victor.safariwalk.ui.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.victor.safariwalk.ui.navigation.ROUTES
import com.victor.safariwalk.ui.theme.primaryColor
import com.victor.safariwalk.ui.theme.purpleColor

@Composable
fun ProfileScreen(navController: NavHostController, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "My Profile",
            style = TextStyle(
                fontSize = 28.sp,
                color = purpleColor,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        ProfilePicture()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Welcome to Kenya!!",
            style = TextStyle(
                fontSize = 24.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        // Navigation to Messages
        Button(
            onClick = { navController.navigate(ROUTES.Messages.name) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
            shape = MaterialTheme.shapes.medium
        ) {
            Icon(Icons.Default.Chat, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Go to Messages", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ProfilePicture() {
    Box(
        modifier = Modifier.size(140.dp)
    ) {
        // The circular profile image
        AsyncImage(
            model = "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg",
            contentDescription = "Profile Picture",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .border(3.dp, purpleColor, CircleShape),
            contentScale = ContentScale.Crop
        )

        // The camera icon overlay
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(purpleColor)
                .align(Alignment.BottomEnd)
                .border(2.dp, Color.White, CircleShape)
                .clickable { /* TODO: Implement Image Picker */ },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.CameraAlt,
                contentDescription = "Change Profile Picture",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
