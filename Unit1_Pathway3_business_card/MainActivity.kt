package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    val avatarImage = painterResource(R.drawable.card_avatar);
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = avatarImage,
            contentDescription = null,
            modifier = Modifier.width(180.dp)
        )
        Text(
            text = "Trần Đăng Duật",
            fontSize = 30.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = "Software Engineer",
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD9601F),
            fontSize = 16.sp,
        )
    }
}

@Composable
fun ContactLine(icon: Painter, text: String) {
    Row(
        modifier = Modifier.padding(vertical = 5.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.width(25.dp)
        )
        Text(
            text = text,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    val phoneIcon = painterResource(R.drawable.phone_solid_full)
    val facebookIcon = painterResource(R.drawable.facebook_brands_solid_full)
    val mailIcon = painterResource(R.drawable.envelope_solid_full)
    Column {
        ContactLine(icon = phoneIcon, text= "+84 359 662 456")
        ContactLine(icon = facebookIcon, text= "@kussssso")
        ContactLine(icon = mailIcon, text= "23020023@vnu.edu.vn")
    }
}

@Composable
fun BusinessCard() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFFEFDB)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            AboutSection()
            ContactSection()

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    BusinessCardTheme {
        BusinessCard()
    }
}