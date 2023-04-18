package com.example.worldnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.worldnews.R
import com.example.worldnews.model.news.Article
import com.example.worldnews.model.news.ArticleX
import com.example.worldnews.model.news.Everything
import com.google.gson.annotations.Until

class SearchAdapter (val list: ArrayList<ArticleX>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    var detail: ((ArticleX) -> Unit)? =null

    var shareClick:((ArticleX) -> Unit)? = null

    fun submitList(everything: ArrayList<ArticleX>){
       list.clear()
       list.addAll(everything)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
       return SearchViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val for_search =list[position]
        if (holder is SearchViewHolder){
            holder.apply {
             tv_about.text = for_search.content
                tv_secondabout.text = for_search.description
                tv_name.text = for_search.author
                tv_time.text = for_search.publishedAt
                Glide.with(iv_news).load(for_search.urlToImage).into(iv_news)
                ln_item.setOnClickListener {
                     detail?.invoke(for_search)
                }

            }
        }

    }
    override fun getItemCount(): Int {
        return list.size
    }
    class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ln_item=view.findViewById<LinearLayout>(R.id.ln_item)
        val iv_news=view.findViewById<ImageView>(R.id.iv_news)
        val tv_about=view.findViewById<TextView>(R.id.tv_about)
        val tv_secondabout=view.findViewById<TextView>(R.id.tv_secondabout)
        val tv_name=view.findViewById<TextView>(R.id.tv_name)
        val tv_time=view.findViewById<TextView>(R.id.tv_time)

    }
}