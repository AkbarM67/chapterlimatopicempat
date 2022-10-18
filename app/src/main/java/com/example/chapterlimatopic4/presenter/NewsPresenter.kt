package com.example.chapterlimatopic4.presenter

import android.util.Log
import com.example.chapterlimatopic4.model.getAllNewsItem
import com.example.chapterlimatopic4.network.apiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPresenter(val viewnews: NewsView) {

    fun getDataNews(){

        apiClient.instance.getallNews()
            .enqueue(object : Callback<List<getAllNewsItem>>{
                override fun onResponse(
                    call: Call<List<getAllNewsItem>>,
                    response: Response<List<getAllNewsItem>>
                ) {
                    if (response.isSuccessful){
                        viewnews.onSuccess(response.message(),response.body()!!)
                        //Log.d("oi", response.body().toString())
                    }else{
                        viewnews.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<getAllNewsItem>>, t: Throwable) {
                    viewnews.onError(t.message!!)
                }

            })
    }
}