import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.localizeit.ui.theme.LocalizeItTheme
import com.example.localizeit.ui.theme.Screens.DashboardScreen
import com.example.localizeit.ui.theme.Screens.EducationScreen

//import com.localizeit.presentation.screens.dashboard.DashboardScreen
//import com.localizeit.presentation.screens.education.EducationScreen
//import com.localizeit.presentation.screens.education.LessonDetailScreen
//import com.localizeit.presentation.screens.education.lessonList
//import com.localizeit.presentation.theme.LocalizeItTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocalizeItApp()
        }
    }
}

@Composable
fun LocalizeItApp() {
    LocalizeItTheme {
        Surface(color = Color(0xFF121212)) {
            val navController = rememberNavController()


            NavHost(
                navController = navController,
                startDestination = "register"
            ) {
                composable("register") {
                    DashboardScreen(navController)
                }
                composable("education") {
                    EducationScreen(navController)
                }
                composable(
                    "lessonDetail/{title}/{category}/{content}",
                    arguments = listOf(
                        navArgument("title") { type = NavType.StringType },
                        navArgument("category") { type = NavType.StringType },
                        navArgument("content") { type = NavType.StringType }
                    )
                ) { backStackEntry ->
                    val title = backStackEntry.arguments?.getString("title") ?: ""
                    val category = backStackEntry.arguments?.getString("category") ?: ""
                    val content = backStackEntry.arguments?.getString("content") ?: ""

//                    LessonDetailScreen(
//                        navController = navController,
//                        title = title,
//                        category = category,
//                        content = content
//                    )
                }

                // Optional: Add more screens
                composable("profile") { /* ProfileScreen(navController) */ }
                composable("jobs") { /* JobsScreen(navController) */ }
                composable("services") { /* ServicesScreen(navController) */ }
                composable("settings") { /* SettingsScreen(navController) */ }
            }
        }
    }}