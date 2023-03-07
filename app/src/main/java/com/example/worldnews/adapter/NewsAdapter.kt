package com.example.worldnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.worldnews.R
import com.example.worldnews.model.Article
import com.example.worldnews.model.News

class NewsAdapter(val News: ArrayList<News>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false))

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val init= News[position]
        holder.apply {
            tv_about.text=init.toString()
            tv_secondabout.text=init.toString()
            tv_name.text=init.toString()
            tv_time.text=init.toString()
        }
    }
    override fun getItemCount(): Int {
        return News.size
    }

    class NewsViewHolder(news: View): RecyclerView.ViewHolder(news){
        val tv_about=news.findViewById<TextView>(R.id.tv_about)
        val tv_secondabout=news.findViewById<TextView>(R.id.tv_secondabout)
        val tv_name=news.findViewById<TextView>(R.id.tv_name)
        val tv_time=news.findViewById<TextView>(R.id.tv_time)
    }
}