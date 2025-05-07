package com.localizeit.ui

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(true) {
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate("onboarding") {
                popUpTo("splash") { inclusive = true }
            }
        }, 2000)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00D1B2)),
        contentAlignment = Alignment.Center
    ) {
        Text("LocalizeIt", fontSize = 36.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}
