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
import com.example.worldnews.model.news.New

class SaveAdapter(val list: ArrayList<Article>): RecyclerView.Adapter<SaveAdapter.SaveViewHolder>() {
    var detail:((String)->Unit)?=null

    var shareClick:((Article)->Unit)?=null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveViewHolder {
        return SaveViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false))
    }
    override fun onBindViewHolder(holder: SaveViewHolder, position: Int) {
        val for_save=list[position]
         if (holder is SaveViewHolder){
             holder.apply {
                 tv_about.text = for_save.content
                 tv_secondabout.text = for_save.description
                 tv_name.text = for_save.author
                 tv_time.text = for_save.publishedAt
                 Glide.with(iv_news).load(for_save.urlToImage).into(iv_news)
                 tv_about.text = for_save.title
                 ln_item.setOnClickListener {
                     shareClick?.invoke(for_save)
                 }
             }
         }
    }
    override fun getItemCount(): Int {
     return list.size
    }
    class SaveViewHolder(view: View): RecyclerView.ViewHolder(view){
        val ln_item=view.findViewById<LinearLayout>(R.id.ln_item)
        val iv_news=view.findViewById<ImageView>(R.id.iv_news)
        val tv_about=view.findViewById<TextView>(R.id.tv_about)
        val tv_secondabout=view.findViewById<TextView>(R.id.tv_secondabout)
        val tv_name=view.findViewById<TextView>(R.id.tv_name)
        val tv_time=view.findViewById<TextView>(R.id.tv_time)
    }

    fun submitList(newlist: ArrayList<Article>) {
        list.addAll((newlist))
        notifyDataSetChanged()
    }
}


