package com.example.localizeit.ui.theme.Screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
//mport androidx.compose.material.icons.filled.MenuBook
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
//import com.localizeit.R

//val CodeFont = FontFamily(Font(R.font.jetbrains_mono))

data class Lesson(
    val title: String,
    val category: String,
    val contentPreview: String
)

val lessonList = listOf(
// Agriculture
    Lesson(
        "Soil Preparation",
        "Agriculture",
        "Learn how to properly prepare your land for planting with simple tools and organic methods."
    ),
    Lesson(
        "Crop Rotation 101",
        "Agriculture",
        "Understand how rotating crops can improve yields and reduce pests naturally."
    ),
    Lesson(
        "Water Conservation in Farming",
        "Agriculture",
        "Tips and techniques for making the most of water in drought-prone areas."
    ),
// Entrepreneurship
    Lesson(
        "Starting a Small Business",
        "Entrepreneurship",
        "Steps to legally and successfully start a micro-enterprise in your region."
    ),
    Lesson(
        "Financial Literacy",
        "Entrepreneurship",
        "Learn how to save, budget, and grow your earnings through practical money tips."
    ),
    Lesson(
        "Digital Marketing Basics",
        "Entrepreneurship",
        "Introduction to promoting products and services online using free tools."
    ),
// Healthcare
    Lesson(
        "Basic First Aid",
        "Health",
        "How to handle cuts, burns, and fainting before medical help arrives."
    ),
    Lesson(
        "Preventing Common Diseases",
        "Health",
        "Simple hygiene practices to prevent cholera, malaria, and respiratory infections."
    ),
    Lesson(
        "Maternal Care",
        "Health",
        "Essential practices and signs during pregnancy to ensure a safe delivery."
    )
)

@Composable
fun EducationScreen(navController: NavController) {
    Scaffold(
        backgroundColor = Color(0xFF121212),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "fun EducationScreen() {",
                        style = TextStyle(fontFamily = FontFamily.SansSerif, fontSize = 18.sp, color = Color.Cyan)
                    )
                },
                backgroundColor = Color(0xFF1E1E1E),
                elevation = 8.dp
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            var currentCategory = ""
            itemsIndexed(lessonList) { index, lesson ->
                if (lesson.category != currentCategory) {
                    //currentCategory = lesson.category

                        Text(
                            text = "\n // ${lesson.category.uppercase()} LESSONS",
                            style = TextStyle(fontFamily = FontFamily.SansSerif, fontSize = 16.sp, color = Color.Gray),
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                }



//                    LessonCard(lesson)

            }


                Text(
                    text = "}",
                    style = TextStyle(fontFamily = FontFamily.SansSerif, fontSize = 18.sp, color = Color.Cyan),
                    modifier = Modifier.padding(vertical = 24.dp)
                )

        }
    }


@Composable
fun LessonCard(lesson: Lesson) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable {
// future navigation: navController.navigate("lessonDetail/${lesson.title}")
            },
        backgroundColor = Color(0xFF1E1E1E),
        elevation = 6.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "lesson",
                tint = Color(0xFFB8F1FF),
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier.width(300.dp).padding(12.dp)
            ) {
                Text(
                    text = " = ${lesson.title.replace(" ", "-").lowercase()} = Lesson(${lesson.title})",
                    fontSize = 15.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = " ${lesson.contentPreview.take(60)}...",
                    modifier = Modifier.padding(top = 4.dp),
                    fontSize = 13.sp,
                    color = Color.LightGray
                )

            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF121212, showSystemUi = true)
@Composable
fun EducationScreenPreview() {
    val nav = androidx.navigation.compose.rememberNavController()
    MaterialTheme {
        EducationScreen(navController = nav)
    }
}