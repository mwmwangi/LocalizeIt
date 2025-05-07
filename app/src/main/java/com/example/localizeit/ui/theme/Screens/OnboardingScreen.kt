//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
////import com.google.accompanist.kjpager.*
//import kotlinx.coroutines.launch
//
////@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun OnboardingScreen(navController: NavController) { val pagerState = rememberPagerState()
//    val scope = rememberCoroutineScope()
//
//    val pages = listOf(
//        OnboardingPage("Learn Skills Anywhere", "Access practical skills in your language, even offline."),
//        OnboardingPage("Jobs & Resources", "Discover job openings and community tools near you."),
//        OnboardingPage("Get Started", "Let’s build your journey today.")
//    )
//
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = Color(0xFF1E1E1E)
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(24.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            HorizontalPager(
//                count = pages.size,
//                state = pagerState,
//                modifier = Modifier.weight(1f)
//            ) { page ->
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier.fillMaxSize()
//                ) {
//                    Text(text = pages[page].title, color = Color.White, style = MaterialTheme.typography.headlineSmall)
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Text(text = pages[page].description, color = Color(0xFFBBBBBB), style = MaterialTheme.typography.bodyLarge)
//                }
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            HorizontalPagerIndicator(
//                pagerState = pagerState,
//                activeColor = Color(0xFF1EB980),
//                inactiveColor = Color.Gray
//            )
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            Button(
//                onClick = {
//                    if (pagerState.currentPage == pages.lastIndex) {
//                        navController.navigate("dashboard") {
//                            popUpTo("welcome") { inclusive = true }
//                        }
//
//                    } else {
//                        scope.launch {
//                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
//                        }
//                    }
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1EB980))
//            ) {
//                Text(text = if (pagerState.currentPage == pages.lastIndex) "Get Started" else "Next")
//            }
//        }
//    }
//}
//
//data class OnboardingPage(val title: String, val description: String)
