package com.localizelt.ui.html

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun EmbeddedYouTubeVideo(
    modifier: Modifier = Modifier,
    videoId: String
) {
    val isInEditMode = LocalInspectionMode.current
    if (isInEditMode) {
        // Show placeholder box with a play icon for preview in Android Studio
        Box(
            modifier = modifier
                .background(
                    Brush.radialGradient(
                        colors = listOf(Color(0xFF6A11CB), Color(0xFF2575FC)),
                        center = Alignment.Center,
                        radius = 300f
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
                .fillMaxWidth()
                .height(210.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "YouTube Video Preview",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    } else {
        AndroidView(
            modifier = modifier
                .fillMaxWidth()
                .height(210.dp)
                .clip(RoundedCornerShape(20.dp))
                .shadow(12.dp, RoundedCornerShape(20.dp)),
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true
                    settings.domStorageEnabled = true
                    webViewClient = WebViewClient()
                    // Prevent scrolling inside WebView for better UX
                    setOnTouchListener { _, _ -> true }
                    loadUrl("https://www.youtube.com/embed/$videoId?rel=0&modestbranding=1")
                }
            },
            update = { webView ->
                webView.loadUrl("https://www.youtube.com/embed/$videoId?rel=0&modestbranding=1")
            }
        )
    }
}

@Composable
fun HtmlScreen(
    modifier: Modifier = Modifier
) {
    val gradientColors = listOf(Color(0xFF6A11CB), Color(0xFF2575FC))
    val background = Brush.verticalGradient(gradientColors)

    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(background)
            .padding(20.dp),
        color = Color.Transparent,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title with gradient text
            GradientText(
                text = "Complete HTML Course",
                fontSize = 32.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "Master HTML from basics to advanced topics in this comprehensive course. Understand tags, forms, tables, multimedia, semantics, and best practices to build robust web pages.",
                color = Color(0xFFE0E0E0),
                fontSize = 16.sp,
                lineHeight = 22.sp,
                modifier = Modifier.padding(horizontal = 12.dp),
                textAlign = TextAlign.Center
            )

            EmbeddedYouTubeVideo(
                videoId = "UB1O30fR-EE",
                modifier = Modifier
                    .fillMaxWidth()
            )

            LessonSection(
                title = "1. HTML Document Structure",
                description = "The skeleton of every webpage: declaring doctype, html, head, body tags with sample.",
                code = """
                    <!DOCTYPE html>
                    <html>
                      <head>
                        <title>My First Webpage</title>
                      </head>
                      <body>
                        <h1>Welcome!</h1>
                        <p>This is my first webpage.</p>
                      </body>
                    </html>
                """.trimIndent()
            )

            LessonSection(
                title = "2. Text Formatting Tags",
                description = "Use tags like <b>, <i>, <u>, <strong>, <em>, <mark> to emphasize text.",
                code = """
                    <p>This is <b>bold</b>, <i>italic</i>, <u>underlined</u> and <mark>highlighted</mark> text.</p>
                """.trimIndent()
            )

            LessonSection(
                title = "3. Links and Images",
                description = "Embed links with <a> and images with <img>, important attributes explained.",
                code = """
                    <a href="https://localizelt.org">Visit Localizelt</a>
                    <img src="https://images.pexels.com/photos/1103533/pexels-photo-1103533.jpeg" alt="Sample Image" width="200" />
                """.trimIndent()
            )

            LessonSection(
                title = "4. Lists and Tables",
                description = "Ordered and unordered lists help organize content; tables present tabular data.",
                code = """
                    <ul>
                      <li>Milk</li>
                      <li>Bread</li>
                      <li>Eggs</li>
                    </ul>
                    <table border="1">
                      <tr><th>Name</th><th>Age</th></tr>
                      <tr><td>Amina</td><td>25</td></tr>
                      <tr><td>John</td><td>30</td></tr>
                    </table>
                """.trimIndent()
            )

            LessonSection(
                title = "5. Forms and Inputs",
                description = "Collect user input using forms with textboxes, radio buttons, checkboxes, and submit button.",
                code = """
                    <form action="/submit" method="post">
                      <label>Name: <input type="text" name="name" /></label><br/>
                      <label>Gender:</label>
                      <input type="radio" name="gender" value="male" /> Male
                      <input type="radio" name="gender" value="female" /> Female<br/>
                      <label><input type="checkbox" name="subscribe" /> Subscribe to newsletter</label><br/>
                      <button type="submit">Submit</button>
                    </form>
                """.trimIndent()
            )

            LessonSection(
                title = "6. Multimedia: Audio and Video",
                description = "Include audio or video files directly in your webpage using <audio> and <video>.",
                code = """
                    <audio controls>
                      <source src="audio.mp3" type="audio/mpeg">
                      Your browser does not support the audio element.
                    </audio>
                    <video width="320" height="240" controls>
                      <source src="video.mp4" type="video/mp4">
                      Your browser does not support the video tag.
                    </video>
                """.trimIndent()
            )

            LessonSection(
                title = "7. Semantic HTML",
                description = "Use semantic tags like <header>, <footer>, <article>, <section> for better structure and accessibility.",
                code = """
                    <header>
                      <h1>Site Title</h1>
                      <nav> ... </nav>
                    </header>
                    <section>
                      <article> ... </article>
                    </section>
                    <footer>Contact info</footer>
                """.trimIndent()
            )

            LessonSection(
                title = "8. Best Practices",
                description = "Write clean, semantic, accessible HTML with proper indentation and commenting.",
                code = """
                    <!-- This is a comment -->
                    <p>Clean, readable code helps maintainability.</p>
                """.trimIndent()
            )

            Text(
                text = "Practice Task:",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color(0xFFCCCFFF),
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Build a multi-section HTML page using headings, paragraphs, images, lists, and forms. Include at least one audio or video file and use semantic tags. Make sure your code is indented and commented properly.",
                color = Color(0xFFE0E0E0),
                fontSize = 16.sp,
                lineHeight = 22.sp,
                modifier = Modifier.padding(horizontal = 14.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
fun GradientText(
    text: String,
    fontSize: Int = 28,
    fontWeight: FontWeight = FontWeight.Bold,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFFFC5C7D), Color(0xFF6A82FB))
    )
    Text(
        text = text,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge,
        color = Color.Unspecified,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        softWrap = false,
        inlineContent = emptyMap(),
        onTextLayout = {},
        // Draw gradient text with brush
        // Compose as of now requires a little hack for gradient text
        // Using this color with brush in TextStyle (Below)
        style = MaterialTheme.typography.headlineLarge.copy(
            brush = gradient,
            fontWeight = fontWeight,
            fontSize = fontSize.sp
        )
    )
}

@Composable
fun LessonSection(
    title: String,
    description: String,
    code: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFF312F44), Color(0xFF1B1A2A))
                ),
                shape = RoundedCornerShape(20.dp)
            )
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(20.dp),
                clip = false,
                ambientColor = Color(0xFF6A82FB),
                spotColor = Color(0xFF2575FC)
            )
            .padding(20.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color(0xFFDDE6FF),
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(12.dp),
                clip = false,
                ambientColor = Color(0xFF6A82FB),
                spotColor = Color(0xFF2575FC)
            )
        )
        Text(
            text = description,
            color = Color(0xFFBFC7E1),
            fontSize = 15.sp,
            lineHeight = 20.sp,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        CodeBlock(code = code)
    }
}

@Composable
fun CodeBlock(code: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFF192744), Color(0xFF0E1248))
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(18.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        SelectionContainer {
            Text(
                text = code,
                fontFamily = FontFamily.Monospace,
                fontSize = 14.sp,
                color = Color(0xFF7FFFD4),
                lineHeight = 20.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HtmlScreenPreview() {
    HtmlScreen()
}