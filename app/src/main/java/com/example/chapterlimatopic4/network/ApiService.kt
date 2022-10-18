package com.example.chapterlimatopic4.network

import com.example.chapterlimatopic4.model.getAllNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("admin/car")
    fun getallNews() : Call<List<getAllNewsItem>>
}