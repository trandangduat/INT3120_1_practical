package com.example.bookshelf.data.network

import com.example.bookshelf.data.model.BookItem
import com.example.bookshelf.data.model.BookResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface BookApiService {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 20
    ): BookResponse

    @GET("volumes/{id}")
    suspend fun getBookDetails(@Path("id") id: String): BookItem
}
