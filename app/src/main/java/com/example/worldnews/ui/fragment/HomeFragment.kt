package com.example.worldnews.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.worldnews.R
import com.example.worldnews.adapter.NewsAdapter
import com.example.worldnews.data.remote.ApiClient
import com.example.worldnews.databinding.FragmentHomeBinding
import com.example.worldnews.model.news.Article
import com.example.worldnews.model.news.New
import com.example.worldnews.utils.viewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding { FragmentHomeBinding.bind(it) }
     var list= ArrayList<Article>()
    lateinit var adapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         initView()
    }

    private fun initView() {
        getNews()
        binding.apply {
            adapter=NewsAdapter(list)
                rvNews.adapter=adapter
                rvNews.layoutManager=GridLayoutManager(requireContext(),1)
        }
    }
    private fun getNews(){
      ApiClient.apiService.getNews().enqueue(object :Callback<New>{
          override fun onResponse(call: Call<New>, response: Response<New>) {
              if (response.isSuccessful){
                  Log.d("@@@@@", "onResponse: ${response.body()}")
                  list = response.body()!!.articles
                  adapter.submitList(list)
              }
          }

          override fun onFailure(call: Call<New>, t: Throwable) {

          }

      })
  }







    }


