package com.example.chapterlimatopic4.view

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.chapterlimatopic4.R
import com.example.chapterlimatopic4.databinding.ActivityDetailBinding

class Activity_detail : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detailData()
    }

    fun detailData(){
        val intent: Intent = intent
        var status = intent.getStringExtra("status")

        Glide.with(this).load(intent.getStringExtra("image")).into(binding.ivDetail)
        binding.tvStatusDetail.text = intent.getStringExtra("status")
        binding.tvName.text = intent.getStringExtra("name")
        binding.tvPriceDetail.text = intent.getIntExtra("price",0).toString()

        Log.d(TAG, "detailData: ${status}")
    }
}