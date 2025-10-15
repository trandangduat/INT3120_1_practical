package com.example.bookshelf.data

import com.example.bookshelf.data.network.BookApiService
import com.example.bookshelf.data.repository.BooksRepository
import com.example.bookshelf.data.repository.DefaultBooksRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val booksRepository: BooksRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }

    /**
     * DI implementation for Amphibians repository
     */
    override val booksRepository: BooksRepository by lazy {
        DefaultBooksRepository(retrofitService)
    }
}
