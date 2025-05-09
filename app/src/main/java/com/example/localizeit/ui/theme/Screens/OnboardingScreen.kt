//package com.example.localizeit.ui.theme.Screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.pager.HorizontalPager
//import androidx.compose.foundation.pager.rememberPagerState
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.localizeit.R
//import kotlinx.coroutines.launch
//
//data class OnboardingPage(
//    val title: String,
//    val description: String,
//    val imageRes: Int
//)
//
//val onboardingPages = listOf(
//    OnboardingPage(
//        title = "Learn Locally",
//        description = "Access free courses tailored to your region.",
//        imageRes = R.drawable.ic_school
//    ),
//    OnboardingPage(
//        title = "Grow Skills",
//        description = "Build skills in farming, health, business, and more.",
//        imageRes = R.drawable.ic_skills
//    ),
//    OnboardingPage(
//        title = "Get Connected",
//        description = "Find local services and job opportunities.",
//        imageRes = R.drawable.ic_connect
//    )
//)
//
//@Composable
//fun OnboardingScreen(onFinish: () -> Unit) {
//    val pagerState = rememberPagerState(initialPage = 0)
//    val coroutineScope = rememberCoroutineScope()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFF121212))
//            .padding(16.dp),
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//        HorizontalPager(
//            pageCount = onboardingPages.size,
//            state = pagerState,
//            modifier = Modifier.weight(1f)
//        ) { page ->
//            val onboarding = onboardingPages[page]
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Image(
//                    painter = painterResource(id = onboarding.imageRes),
//                    contentDescription = onboarding.title,
//                    modifier = Modifier.size(200.dp)
//                )
//                Spacer(modifier = Modifier.height(24.dp))
//                Text(
//                    text = onboarding.title,
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White
//                )
//                Spacer(modifier = Modifier.height(12.dp))
//                Text(
//                    text = onboarding.description,
//                    fontSize = 16.sp,
//                    color = Color.LightGray,
//                    modifier = Modifier.padding(horizontal = 24.dp),
//                    lineHeight = 22.sp
//                )
//            }
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 24.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                repeat(onboardingPages.size) { index ->
//                    val isSelected = pagerState.currentPage == index
//                    Box(
//                        modifier = Modifier
//                            .size(if (isSelected) 12.dp else 8.dp)
//                            .background(
//                                if (isSelected) Color.White else Color.Gray,
//                                shape = RoundedCornerShape(50)
//                            )
//                    )
//                }
//            }
//
//            Button(
//                onClick = {
//                    if (pagerState.currentPage == onboardingPages.lastIndex) {
//                        onFinish()
//                    } else {
//                        coroutineScope.launch {
//                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
//                        }
//                    }
//                },
//                shape = RoundedCornerShape(12.dp)
//            ) {
//                Text(
//                    text = if (pagerState.currentPage == onboardingPages.lastIndex) "Get Started" else "Next"
//                )
//            }
//        }
//    }
//}
