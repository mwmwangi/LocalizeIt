package com.example.localizeit.ui.theme.Screens

//package com.example.localizeit.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ServicesDirectoryScreen(navController: NavController) {
    val services = listOf("Local Clinic", "Agricultural Office", "Community Center")
    Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column {
            Text("Essential Services", style = MaterialTheme.typography.h5)
            Spacer(Modifier.height(16.dp))
            services.forEach {
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
