package com.example.images

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.images.ui.theme.ImagesTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.layout.ContentScale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImagesTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    GreetingImage(
                        msg = "hpbd kusso!",
                        sender = "from duat"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(msg: String, sender: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = msg,
            fontSize = 100.sp,
            lineHeight = 90.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = sender,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(msg: String, sender: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            msg = msg,
            sender = sender,
            modifier = Modifier.fillMaxSize().padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    ImagesTheme {
//        GreetingText(msg = "Happy Birthday Kuso", sender = "Duat")
        GreetingImage(
            msg = "hpbd kusso!",
            sender = "from duat"
        )
    }
}