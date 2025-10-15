package com.example.bookshelf.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.model.BookItem
import com.example.bookshelf.data.repository.BooksRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException

sealed interface BooksUiState {
    object Loading : BooksUiState
    data class Success(val books: List<BookItem>) : BooksUiState
    object Error : BooksUiState
}

class BooksViewModel(private val repository: BooksRepository) : ViewModel() {
    var uiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        fetchBooks(query = "money")
    }

    fun fetchBooks(query: String) {
        viewModelScope.launch {
            try {
                uiState = BooksUiState.Success(repository.getBooks(query))
            } catch (e: IOException) {
                BooksUiState.Error
            } catch (e: HttpException) {
                BooksUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as BookshelfApplication)
                val booksRepository = application.container.booksRepository

                BooksViewModel(repository = booksRepository)
            }

        }
    }
}
