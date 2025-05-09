package com.example.localizeit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.localizeit.ui.theme.Screens.ChatBotScreen
//import com.example.localizeit.ui.Screens.*
import com.example.localizeit.ui.theme.Screens.DashboardScreen
import com.example.localizeit.ui.theme.Screens.EducationScreen
import com.example.localizeit.ui.theme.Screens.JobListingScreen
import com.example.localizeit.ui.theme.Screens.ServicesDirectoryScreen
import com.example.localizeit.ui.theme.Screens.WelcomeScreen

@Composable
fun LocalizeItApp() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable(ROUTE_WELCOME) { WelcomeScreen { navController } }
     //   composable("onboarding") { OnboardingScreen{(navController) }}
        composable(ROUTE_DASHBOARD) { DashboardScreen(navController) }
        composable(ROUTE_EDUCATION) { EducationScreen(navController) }
        composable(ROUTE_JOB_LISTING) { JobListingScreen(navController) }
        composable(ROUTE_SERVICE_DIRECTORY) { ServicesDirectoryScreen(navController) }
        composable("chatbot") { ChatBotScreen(navController) }
    }
}
