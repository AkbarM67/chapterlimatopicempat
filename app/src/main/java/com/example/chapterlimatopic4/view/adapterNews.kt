package com.example.chapterlimatopic4.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chapterlimatopic4.R
import com.example.chapterlimatopic4.databinding.ItemViewBinding
import com.example.chapterlimatopic4.model.getAllNews
import com.example.chapterlimatopic4.model.getAllNewsItem
import kotlinx.android.synthetic.main.item_view.view.*

class adapterNews(private var newsdata : List<getAllNewsItem>):RecyclerView.Adapter<adapterNews.ViewHolder>() {
    lateinit var context: Context

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterNews.ViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvtitle.text= newsdata[position].name
        holder.itemView.tvprice.text= newsdata[position].price.toString()
        Glide.with(holder.itemView.context).load(newsdata[position].image).into(holder.itemView.image)

        holder.itemView.btn_detail.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("status", newsdata[position].status.toString())
            bundle.putString("name",newsdata[position].name)
            bundle.putString("image",newsdata[position].image)
            bundle.putInt("price",newsdata[position].price)

            val intent = Intent(context, Activity_detail::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun getItemCount(): Int {
        return newsdata.size
    }


}