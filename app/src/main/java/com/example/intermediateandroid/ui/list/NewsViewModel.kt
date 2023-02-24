package com.example.intermediateandroid.ui.list

import androidx.lifecycle.ViewModel
import com.example.intermediateandroid.data.NewsRepository

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getHeadlineNews() = newsRepository.getHeadlineNews()

    fun getBookmarkedNews() = newsRepository.getBookmarkedNews()
}