package com.example.bookshelf.data.repository

import android.util.Log
import com.example.bookshelf.data.model.BookItem
import com.example.bookshelf.data.network.BookApiService

interface BooksRepository {
    suspend fun getBooks(query: String): List<BookItem>
}

class DefaultBooksRepository(
    private val api: BookApiService
): BooksRepository {
    override suspend fun getBooks(query: String): List<BookItem> {
        val response = api.searchBooks(query = query, maxResults = 40)
        return response.items ?: emptyList()
    }
}
