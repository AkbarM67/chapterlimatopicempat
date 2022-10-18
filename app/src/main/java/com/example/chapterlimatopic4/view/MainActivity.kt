package com.example.chapterlimatopic4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapterlimatopic4.R
import com.example.chapterlimatopic4.databinding.ActivityMainBinding
import com.example.chapterlimatopic4.model.getAllNewsItem
import com.example.chapterlimatopic4.presenter.NewsPresenter
import com.example.chapterlimatopic4.presenter.NewsView
import com.example.chapterlimatopic4.view.adapterNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsView {

    lateinit var newsPresenter : NewsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsPresenter = NewsPresenter(this)
        newsPresenter.getDataNews()

    }

    override fun onSuccess(pesan:String, viewnews:List<getAllNewsItem>){
       rvCar.layoutManager = LinearLayoutManager(this)
        rvCar.adapter = adapterNews(viewnews)

    }

    override fun onError(pesan: String) {
        Toast.makeText(this,pesan,Toast.LENGTH_LONG).show()
    }
}