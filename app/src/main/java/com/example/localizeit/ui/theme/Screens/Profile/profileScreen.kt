package com.localizelt.ui.profile

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.localizeit.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    userName: String = "Amina Yusuf",
    userEmail: String = "amina.yusuf@example.com",
    userAvatarUrl: String? = null,
    nativeLanguages: List<String> = listOf("Swahili", "English"),
    coursesCompleted: Int = 8,
    jobsApplied: Int = 3,
    modifier: Modifier = Modifier,
    onEditProfileClicked: () -> Unit = {},
    onOfflineContentClicked: () -> Unit = {},
) {
    // A futuristic color palette
    val gradientColors = listOf(Color(0xFF6A11CB), Color(0xFF2575FC))
    val backgroundGradient = Brush.verticalGradient(
        colors = gradientColors
    )

    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundGradient)
            .verticalScroll(rememberScrollState()),
        color = Color.Transparent,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 32.dp, horizontal = 24.dp)
        ) {
            // Profile Picture with glowing shadow
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .shadow(16.dp, CircleShape, clip = false)
                    .border(
                        width = 3.dp,
                        brush = Brush.radialGradient(
                            colors = listOf(Color.White.copy(alpha = 0.6f), Color.Transparent)
                        ),
                        shape = CircleShape
                    )
                    .background(Color(0xFF1B1B2F), CircleShape)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                if (!userAvatarUrl.isNullOrEmpty()) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(userAvatarUrl)
                            .crossfade(true)
                            .transformations(CircleCropTransformation())
                            .build(),
                        contentDescription = "Profile picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape),
                        placeholder = painterResource(id = R.drawable.ic_placeholder_avatar),
                        error = painterResource(id = R.drawable.ic_placeholder_avatar)
                    )
                } else {
                    // Placeholder circle with initials or icon
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .background(Color(0xFF312F44), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = userName.split(" ").map { it.first() }.joinToString(""),
                            color = Color.White,
                            fontSize = 48.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            Text(
                text = userName,
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = userEmail,
                color = Color(0xFFBBBBBB),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 2.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(12.dp))

            NativeLanguagesSection(nativeLanguages)

            Spacer(Modifier.height(28.dp))

            StatsSection(
                coursesCompleted = coursesCompleted,
                jobsApplied = jobsApplied,
            )

            Spacer(Modifier.height(36.dp))

            ActionButtons(
                onEditProfileClicked = onEditProfileClicked,
                onOfflineContentClicked = onOfflineContentClicked
            )
        }
    }
}

@Composable
private fun NativeLanguagesSection(languages: List<String>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Native Languages",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFFDDDDDD),
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            languages.forEach { lang ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(Color(0xFFFC5C7D), Color(0xFF6A82FB))
                            ),
                            RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        lang,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun StatsSection(
    coursesCompleted: Int,
    jobsApplied: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFF2A2A47), Color(0xFF1C1C2F))
                ),
                RoundedCornerShape(20.dp)
            )
            .padding(vertical = 24.dp, horizontal = 28.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatItem(
            value = coursesCompleted.toString(),
            label = "Courses\nCompleted",
            icon = painterResource(id = R.drawable.ic_courses)
        )
        StatItem(
            value = jobsApplied.toString(),
            label = "Jobs\nApplied",
            icon = painterResource(id = R.drawable.ic_jobs)
        )
    }
}

@Composable
private fun StatItem(
    value: String,
    label: String,
    icon: Painter,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = icon,
            contentDescription = label,
            tint = Color(0xFF6A82FB),
            modifier = Modifier.size(32.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = value,
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = label,
            color = Color(0xFFBBBBBB),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            lineHeight = 14.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ActionButtons(
    onEditProfileClicked: () -> Unit,
    onOfflineContentClicked: () -> Unit,
) {
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF6A82FB),
        contentColor = Color.White
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(52.dp),
            onClick = onEditProfileClicked,
            shape = RoundedCornerShape(28.dp),
            colors = buttonColors,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp,
                pressedElevation = 20.dp,
                disabledElevation = 0.dp
            )
        ) {
            Icon(Icons.Filled.Edit, contentDescription = "Edit profile", modifier = Modifier.size(20.dp))
            Spacer(Modifier.width(8.dp))
            Text("Edit Profile", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(24.dp))

        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(52.dp),
            onClick = onOfflineContentClicked,
            shape = RoundedCornerShape(28.dp),
            border = BorderStroke(2.dp, Color(0xFF6A82FB)),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFF6A82FB),
                containerColor = Color.Transparent
            )
        ) {
            Text("Offline Content", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        userName = "Mercy Mwangi",
        userEmail = "mercywangari246@gmail.com",
        userAvatarUrl = null, // No avatar so shows initials
        nativeLanguages = listOf("Swahili", "English"),
        coursesCompleted = 12,
        jobsApplied = 5,
        onEditProfileClicked = {},
        onOfflineContentClicked = {}
    )
}
