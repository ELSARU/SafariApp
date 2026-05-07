package com.victor.safariwalk.ui.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.victor.safariwalk.ui.navigation.ROUTES
import com.victor.safariwalk.ui.theme.purpleColor
import kotlinx.coroutines.launch

data class OnboardingPage(
    val title: String,
    val description: String,
    val image: String
)

val onboardingPages = listOf(
    OnboardingPage(
        "Explore Kenya",
        "Discover the breathtaking beauty of the Kenyan wilderness and vibrant landscapes.",
        "https://images.pexels.com/photos/3225517/pexels-photo-3225517.jpeg"
    ),
    OnboardingPage(
        "Wild Adventures",
        "Experience thrilling safaris and get closer to nature's most majestic creatures.",
        "https://images.pexels.com/photos/1770809/pexels-photo-1770809.jpeg"
    ),
    OnboardingPage(
        "Peaceful Escapes",
        "Find tranquility in serene lodges and quiet nature walks under the African sun.",
        "https://images.pexels.com/photos/147411/italy-mountains-dawn-daybreak-147411.jpeg"
    )
)

@Composable
fun OnboardingScreen(navController: NavHostController, modifier: Modifier) {
    val pagerState = rememberPagerState(pageCount = { onboardingPages.size })
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Sliding Content
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { pageIndex ->
            val page = onboardingPages[pageIndex]
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = page.image,
                    contentDescription = page.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .padding(24.dp)
                        .clip(MaterialTheme.shapes.large),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = page.title,
                    style = TextStyle(
                        fontSize = 28.sp,
                        color = purpleColor,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = page.description,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(horizontal = 40.dp)
                )
            }
        }

        // Pager Indicators (Dots)
        Row(
            Modifier
                .height(50.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(onboardingPages.size) { iteration ->
                val color = if (pagerState.currentPage == iteration) purpleColor else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp)
                )
            }
        }

        // Action Button
        Button(
            onClick = {
                if (pagerState.currentPage < onboardingPages.size - 1) {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                } else {
                    navController.navigate(ROUTES.Login.name) {
                        popUpTo(ROUTES.Onboarding.name) { inclusive = true }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = if (pagerState.currentPage == onboardingPages.size - 1) "Get Started" else "Next",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Skip Button
        if (pagerState.currentPage < onboardingPages.size - 1) {
            OutlinedButton(
                onClick = {
                    navController.navigate(ROUTES.profile.name) {
                        popUpTo(ROUTES.Onboarding.name) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 8.dp),
                border = null
            ) {
                Text(text = "Skip", color = Color.Gray, fontSize = 16.sp)
            }
        } else {
            Spacer(modifier = Modifier.height(72.dp))
        }
    }
}
