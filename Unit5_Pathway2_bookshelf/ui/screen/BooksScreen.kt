package com.example.bookshelf.ui.screen

import android.util.Log
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bookshelf.data.model.BookItem
import com.example.bookshelf.viewmodel.BooksUiState
import com.example.bookshelf.viewmodel.BooksViewModel

@Composable
fun BooksScreen(
    viewModel: BooksViewModel,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier,

) {

    val uiState = viewModel.uiState

    when (uiState) {
        is BooksUiState.Loading -> {
            CircularProgressIndicator(Modifier.padding(16.dp))
        }
        is BooksUiState.Error -> {
            Text("Error")
        }
        is BooksUiState.Success -> {
            BooksGrid(
                books = uiState.books,
                contentPadding = contentPadding
            )
        }
    }
}

@Composable
fun BooksGrid(
    books: List<BookItem>,
    contentPadding: PaddingValues
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = contentPadding
    ) {
        items(books) { book ->
            val img = book.volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://")

            Column(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = img,
                    contentDescription = book.volumeInfo.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.75f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

//                Text(
//                    text = book.volumeInfo.title,
//                    style = MaterialTheme.typography.bodyMedium,
//                    modifier = Modifier.padding(top = 4.dp)
//                )
            }
        }
    }
}
