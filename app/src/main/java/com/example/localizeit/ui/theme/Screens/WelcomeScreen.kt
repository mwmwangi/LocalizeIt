package com.example.localizeit.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.localizeit.R
import com.example.localizeit.navigation.ROUTE_DASHBOARD

@Composable
fun WelcomeScreen(onGetStarted: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121212)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo), // Replace with your logo
                contentDescription = null,
                modifier = Modifier.size(128.dp),
                // Adjust size as needed

            )
            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Empowering skills. Building futures.",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFBBBBBB)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(

                onClick = onGetStarted,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1EB980))
            ) {
                Text(text = "Get Started")
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen (onGetStarted = { ROUTE_DASHBOARD})
}