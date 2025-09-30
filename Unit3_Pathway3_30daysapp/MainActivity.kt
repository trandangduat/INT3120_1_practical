package com.example.a30daysapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.ui.theme.A30DaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A30DaysApp()
        }
    }
}

@Composable
fun DayItem(
    modifier: Modifier = Modifier,
    painter: Painter,
    item: Item
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(5)))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(20.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = item.title,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = item.description,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun A30DaysAppLayout(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val items = generateItems()

    val imageList = List(30) { index ->
        val resName = "img_${index + 1}"
        val resId = context.resources.getIdentifier(resName, "drawable", context.packageName)
        painterResource(id = resId)
    }

    Scaffold(
        topBar = {
            TopBar(
                modifier = Modifier
            )
        }
    ) {
        LazyColumn(
            modifier = modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = it
        ) {
            items(imageList.size) { i ->
                DayItem(
                    painter = imageList[i],
                    item = items[i]
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "30 Days App",
                style = MaterialTheme.typography.displayMedium,
            )
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun A30DaysApp() {
    A30DaysAppTheme(
        darkTheme = true
    ) {
        A30DaysAppLayout(modifier = Modifier.fillMaxSize())
    }
}