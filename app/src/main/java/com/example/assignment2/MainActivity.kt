package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2.data.arts
import com.example.assignment2.ui.theme.Assignment2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableIntStateOf(0) }

    val artImage = arts[currentIndex].imageResourceId
    val artName = arts[currentIndex].name
    val artArtist = arts[currentIndex].artist
    val artYear = arts[currentIndex].year

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DisplayImage(artImage)
        Spacer(modifier = Modifier.height(80.dp))
        Title(artName, artArtist, artYear)
        Spacer(modifier = Modifier.height(20.dp))

        // Buttons for Navigation
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NavigationButton(text = "Previous") {
                currentIndex = if (currentIndex > 0) currentIndex - 1 else arts.size - 1
            }

            NavigationButton(text = "Next") {
                currentIndex = (currentIndex + 1) % arts.size
            }
        }
    }
}

@Composable

fun DisplayImage(@DrawableRes image: Int) {
    Surface(
        shadowElevation = 8.dp,
        color = Color.White,
        modifier = Modifier
            .width(400.dp)
            .height(450.dp)
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxSize()
                .padding(44.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Composable
fun Title(@StringRes title: Int, @StringRes artist: Int, year: Int) {
    Card(
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier

            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(title),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    text = stringResource(artist),
                    fontSize = 16.sp,
                    fontWeight= FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "($year)",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun NavigationButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(150.dp)
            .height(50.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text, fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    Assignment2Theme {
        ArtSpaceApp()
    }
}
