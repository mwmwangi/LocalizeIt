package com.example.localizeit.ui.theme.Screens


//package com.example.localizeit.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ChatBotScreen(navController: NavController) {
    var input by remember { mutableStateOf("") }
    var response by remember { mutableStateOf("Hello! I'm your assistant. How can I help you today?") }

    fun processInput(userInput: String): String {
        return when {
            "job" in userInput.lowercase() -> "You can find jobs in the Job Listings section."
            "clinic" in userInput.lowercase() -> "Local clinics are listed under Services."
            "education" in userInput.lowercase() -> "Educational resources include agriculture, health, and business tutorials."
            else -> "I'm here to help! Please ask about jobs, services, or education."
        }
    }

    Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column {
            Text("ChatBot", style = MaterialTheme.typography.h5)
            Spacer(Modifier.height(16.dp))
            Text(text = response, modifier = Modifier.padding(8.dp))
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Ask a question") }
            )
            Spacer(Modifier.height(8.dp))
            Button(onClick = {
                response = processInput(input)
                input = ""
            }) {
                Text("Send")
            }
        }
    }
}
