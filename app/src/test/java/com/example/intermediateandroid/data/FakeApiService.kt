package com.example.intermediateandroid.data

import com.example.intermediateandroid.data.remote.response.NewsResponse
import com.example.intermediateandroid.data.remote.retrofit.ApiService
import com.example.intermediateandroid.utils.DataDummy

class FakeApiService : ApiService {

    private val dummyResponse = DataDummy.generateDummyNewsResponse()
    override suspend fun getNews(apiKey: String): NewsResponse {
        return dummyResponse
    }

}