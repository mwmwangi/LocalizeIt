import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DashboardScreen() {
    val selectedItem = remember { mutableStateOf("home") }

    Scaffold(
        containerColor = Color(0xFF121212),
        bottomBar = {
            BottomNavigationBar(
                selected = selectedItem.value,
                onItemSelected = { selectedItem.value = it }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            DashboardContent()
        }
    }
}

@Composable
fun DashboardContent() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121212)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            item {
                Text(
                    text = "Welcome back 👋",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Featured Skills",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFBBBBBB)
                )

                Spacer(modifier = Modifier.height(12.dp))

                LazyRow {
                    items(5) { index ->
                        SkillCard(
                            title = "Skill ${index + 1}",
                            description = "Short overview",
                            modifier = Modifier.padding(end = 12.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Recommended Jobs",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFBBBBBB)
                )

                Spacer(modifier = Modifier.height(12.dp))
            }

            items(3) { index ->
                JobCard(
                    title = "Community Health Worker",
                    location = "Kisumu County",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }

            item { Spacer(modifier = Modifier.height(40.dp)) }
        }
    }
}

@Composable
fun SkillCard(title: String, description: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .width(200.dp)
            .height(130.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = description, color = Color.Gray, fontSize = 14.sp)
        }
    }
}

@Composable
fun JobCard(title: String, location: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = location, color = Color.Gray, fontSize = 14.sp)
            }
            Text(text = "Apply", color = Color(0xFF1EB980), fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun BottomNavigationBar(selected: String, onItemSelected: (String) -> Unit) {
    NavigationBar(containerColor = Color(0xFF1A1A1A)) {
        val items = listOf("home", "learn", "jobs", "profile")
        val icons = listOf(Icons.Default.Home, Icons.Default.Create, Icons.Default.Build, Icons.Default.Person)
        val labels = listOf("Home", "Learn", "Jobs", "Profile")

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selected == item,
                onClick = { onItemSelected(item) },
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = item,
                        tint = if (selected == item) Color(0xFF1EB980) else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = labels[index],
                        color = if (selected == item) Color(0xFF1EB980) else Color.Gray,
                        fontSize = 12.sp
                    )
                }
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardActivityPreview() {
    DashboardScreen()
}
