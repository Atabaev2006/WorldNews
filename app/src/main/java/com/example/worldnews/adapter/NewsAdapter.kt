package com.example.worldnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.worldnews.R
import com.example.worldnews.model.news.Article


class NewsAdapter(val list: ArrayList<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var shareClick: ((Article) -> Unit)? = null


    var detail: ((String) -> Unit)? = null


    fun submitList(newList: ArrayList<Article>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = list[position]
        if (holder is NewsViewHolder) {
            holder.apply {
                tv_about.text = article.content
                tv_secondabout.text = article.description
                tv_name.text = article.author
                tv_time.text = article.publishedAt
                Glide.with(iv_news).load(article.urlToImage).into(iv_news)
                tv_about.text = article.title

                ln_item.setOnClickListener {
                   shareClick?.invoke(article)
                }

                iv_news.setOnClickListener {

                }
            }
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    class NewsViewHolder(news: View) : RecyclerView.ViewHolder(news) {
        val ln_item = news.findViewById<LinearLayout>(R.id.ln_item)
        val wb_view = news.findViewById<WebView>(R.id.wb_View)
        val iv_news = news.findViewById<ImageView>(R.id.iv_news)
        val tv_about = news.findViewById<TextView>(R.id.tv_about)
        val tv_secondabout = news.findViewById<TextView>(R.id.tv_secondabout)
        val tv_name = news.findViewById<TextView>(R.id.tv_name)
        val tv_time = news.findViewById<TextView>(R.id.tv_time)
    }


}