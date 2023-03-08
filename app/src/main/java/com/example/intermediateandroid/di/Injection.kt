package com.example.intermediateandroid.di

import android.content.Context
import com.example.intermediateandroid.data.QuoteRepository
import com.example.intermediateandroid.database.QuoteDatabase
import com.example.intermediateandroid.network.ApiConfig

object Injection {
    fun provideRepository(context: Context): QuoteRepository {
        val database = QuoteDatabase.getDatabase(context)
        val apiService = ApiConfig.getApiService()
        return QuoteRepository(database, apiService)
    }
}