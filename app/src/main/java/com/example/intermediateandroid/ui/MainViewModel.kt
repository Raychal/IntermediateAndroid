package com.example.intermediateandroid.ui

import android.content.Context
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.intermediateandroid.data.QuoteRepository
import com.example.intermediateandroid.di.Injection
import com.example.intermediateandroid.network.QuoteResponseItem
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    private val _quote = MutableLiveData<List<QuoteResponseItem>>()

    val quote: LiveData<PagingData<QuoteResponseItem>> =
        quoteRepository.getQuote().cachedIn(viewModelScope)
}

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(Injection.provideRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}