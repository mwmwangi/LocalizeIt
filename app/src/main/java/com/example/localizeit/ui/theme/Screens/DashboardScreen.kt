package com.example.localizeit.ui.theme.Screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.localizeit.R

// Load JetBrains Mono font
//val CodeFont = FontFamily(Font(R.font.jetbrains_mono))

data class NavItem(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector, val route: String)

@Composable
fun DashboardScreen(navController: NavController) {
    val items = listOf(
        NavItem("Profile", Icons.Default.Person, "profile"),
        NavItem("Education", Icons.Default.Menu, "education"),
        NavItem("Jobs", Icons.Default.Build, "jobs"),
        NavItem("Services", Icons.Default.Search, "services"),
        NavItem("Settings", Icons.Default.Settings, "settings")

    )
    val selectedItem = remember { mutableStateOf(0) }
    var context = LocalContext.current
    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT,"download app here: https://www.download.com")
        type = "text/plain"


    Scaffold(
        backgroundColor = Color(0xFF121212),
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF1E1E1E),
                elevation = 8.dp
            ) {
                Text(
                    text = "fun LocalizeItDashboard() {",
                    style = TextStyle(
                        fontFamily = FontFamily(),
                        color = Color.Cyan,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        },
        bottomBar= { NavigationBar(containerColor = Color.Cyan) {
            NavigationBarItem(
                selected = selectedItem.value ==0,
                onClick = {selectedItem.value = 0
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel: 0115333698")
                    }
                    context.startActivity(intent)
                },
                icon = { androidx.compose.material3.Icon(Icons.Filled.Phone, contentDescription = "Phone") },
                label = { androidx.compose.material3.Text(text = "Phone") },
                alwaysShowLabel = true
            )
            NavigationBarItem(
                selected = selectedItem.value ==1,
                onClick = {selectedItem.value = 1
                    var intent = Intent( Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mail to : mercywangari246@gmail.com")
                        putExtra(Intent.EXTRA_SUBJECT,"Inquiry")
                        putExtra(Intent.EXTRA_TEXT,"Hello how do I join your school?")
                    }


                    context.startActivity(intent)},
                icon = { androidx.compose.material3.Icon(Icons.Filled.Email, contentDescription = "Email") },
                label = { androidx.compose.material3.Text(text = "Email") },
                alwaysShowLabel = true
            )
//            NavigationBarItem(
//                selected = selectedItem.value ==2,
//                onClick = {selectedItem.value = 2
//                    var sendIntent = Intent().apply {  }
//                    val shareIntent = Intent.CreateChooser(sendIntent,null)
//                          context.startActivity(shareIntent)},
//                icon = { Icon(Icons.Filled.Share, contentDescription = "share")
//                       },
//                label = { Text(text = "Share")},
//                alwaysShowLabel = true
//            )
            NavigationBarItem(
                selected = selectedItem.value == 2,
                onClick = {
                    selectedItem.value = 2
                    val sendIntent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Check out this awesome app!")
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent, null)
                    context.startActivity(shareIntent)
                },
                icon = {
                    androidx.compose.material3.Icon(Icons.Filled.Share, contentDescription = "Share")
                },
                label = { androidx.compose.material3.Text(text = "Share") },
                alwaysShowLabel = true
            )


        } }

    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxSize()
        ) {
//            items(items) { item ->
//                DashboardCodeLine(item = item) {
//                    navController.navigate(item.route)
//                }
//            }
            item {
                Text(
                    text = "}",
                    style = TextStyle(fontFamily = FontFamily(), fontSize = 18.sp, color = Color.Cyan),
                    modifier = Modifier.padding(start = 8.dp, top = 24.dp)
                )
            }
        }
    }
}

@Composable
fun DashboardCodeLine(item: NavItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        backgroundColor = Color(0xFF1E1E1E),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
//            Text(
//                text = " val ${item.label.lowercase()} = navigateTo("${item.route}"dashboard",
//            style = TextStyle(
//                fontFamily = CodeFont,
//                fontSize = 16.sp,
//                color = Color(0xFFB8F1FF)
//            )
//            )
        }
    }
}
    }
@Preview(showBackground = true, backgroundColor = 0xFF121212)
@Composable
fun DashboardScreenPreview() {
    val fakeNavController = rememberNavController()
    MaterialTheme(
        typography = Typography(defaultFontFamily = FontFamily())
    ) {
        DashboardScreen(navController = fakeNavController)
    }
}