package com.example.localizeit.navigation

import DashboardScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.localizeit.navigation.ROUTE_ADD_COURSE
import com.example.localizeit.navigation.ROUTE_CHOOSE_COURSE
import com.example.localizeit.navigation.ROUTE_DASHBOARD
import com.example.localizeit.navigation.ROUTE_LOGIN
import com.example.localizeit.navigation.ROUTE_REGISTER

import com.example.localizeit.ui.theme.Screens.Register.RegisterScreen
import com.example.localizeit.ui.theme.Screens.WelcomeScreen
//import com.example.localizeit.ui.theme.Screens.Dashboard.DashboardScreen
import com.example.localizeit.ui.theme.Screens.Login.LoginScreen
//import com.example.localizeit.ui.theme.Screens.Courses.AddCourseScreen
import com.example.localizeit.ui.theme.Screens.Register.RegisterScreen

@Composable
fun AppNavHost(navController: NavHostController= rememberNavController(), startDestination: String= ROUTE_WELCOME){
    NavHost(navController=navController, startDestination =startDestination ){
        composable(ROUTE_WELCOME) { WelcomeScreen { navController.navigate(ROUTE_REGISTER){
            popUpTo(ROUTE_WELCOME){inclusive=true}} }  }
        composable(ROUTE_REGISTER){ RegisterScreen(navController)}
        composable(ROUTE_LOGIN){ LoginScreen(navController)}
        //composable(ROUTE_DASHBOARD){DashboardScreen(navController)}
        composable(ROUTE_ADD_COURSE){ (navController) }
//     composable(ROUTE_SPLASH) { SplashScreen (navController)  }

    }

}