import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        backgroundColor = Color(0xFF121212),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "fun SettingsScreen() {",
                        fontSize = 18.sp,
                        color = Color.Cyan,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                },
                backgroundColor = Color(0xFF1E1E1E)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "// Settings options",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 8.dp)
            )


            SettingsItem(icon = Icons.Default.List, label = "Language") {
                // navController.navigate("language")
            }

            SettingsItem(icon = Icons.Default.Notifications, label = "Notifications") {
                // toggle notifications
            }

            SettingsItem(icon = Icons.Default.Close, label = "Offline Mode") {
                // toggle offline mode
            }

            SettingsItem(icon = Icons.Default.ThumbUp, label = "Dark Theme") {
                // toggle theme
            }

            SettingsItem(icon = Icons.Default.Info, label = "About") {
                // navController.navigate("about")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "}",
                fontSize = 18.sp,
                color = Color.Cyan,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun SettingsItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },
        backgroundColor = Color(0xFF1E1E1E),
        elevation = 6.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color(0xFF90CAF9),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = label,
                fontSize = 15.sp,
                color = Color.White
            )
        }
    }
}