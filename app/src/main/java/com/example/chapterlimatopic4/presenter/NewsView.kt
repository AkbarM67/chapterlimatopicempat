package com.example.chapterlimatopic4.presenter

import com.example.chapterlimatopic4.model.getAllNewsItem

interface NewsView {


    fun onSuccess(pesan: String, news: List<getAllNewsItem>)
    fun onError(pesan: String)
}