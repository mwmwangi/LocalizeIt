package com.example.localizeit.ui.theme.Screens



import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun JobListingScreen(navController: NavController) {
    val jobs = listOf("Farm Assistant", "Tailor", "Shop Attendant")
    Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column {
            Text("Job Listings", style = MaterialTheme.typography.h5)
            Spacer(Modifier.height(16.dp))
            jobs.forEach {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = 4.dp
                ) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}
