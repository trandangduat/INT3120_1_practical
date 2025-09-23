package com.example.artspace

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpace()
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }

    var imageResource: Int
    var titleResource: Int
    var factResource: Int

    when (count) {
        0 -> {
            imageResource = R.drawable.vinh_halong
            titleResource = R.string.halong_title
            factResource = R.string.halong_fact
        }
        1 -> {
            imageResource = R.drawable.hoang_lien_son
            titleResource = R.string.hoanglien_title
            factResource = R.string.hoanglien_fact
        }
        2 -> {
            imageResource = R.drawable.ho_ba_be
            titleResource = R.string.babe_title
            factResource = R.string.babe_fact
        }
        3 -> {
            imageResource = R.drawable.phu_quoc
            titleResource = R.string.phuquoc_title
            factResource = R.string.phuquoc_fact
        }
        else -> {
            imageResource = R.drawable.son_doong
            titleResource = R.string.sondoong_title
            factResource = R.string.sondoong_fact
        }
    }

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(
            modifier = Modifier.padding(10.dp)
        )
        Image(
            painter = painterResource(imageResource),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = Color(0xFF6484b5))
                .border(width = 2.dp, color = Color(0xFF112a4f))
                .padding(10.dp)
        )
        Spacer(
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = stringResource(titleResource),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color(0xFF112a4f),
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = stringResource(factResource),
            fontSize = 20.sp,
            lineHeight = 30.sp,
            modifier = Modifier
                .background(color = Color(0xFFdce6f5))
                .padding(20.dp)
        )
        Row (
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    count = ((count - 1) % 5 + 5) % 5
                }
            ) {
                Text(text = "Trước", fontSize = 20.sp)
            }
            Button(
                onClick = {
                    count = (count + 1) % 5
                }
            ) {
                Text(text = "Sau", fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpace() {
    ArtSpaceTheme {
        ArtSpaceLayout(modifier = Modifier.fillMaxSize())
    }
}