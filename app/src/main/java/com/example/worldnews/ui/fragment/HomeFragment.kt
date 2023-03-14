package com.example.worldnews.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.worldnews.R
import com.example.worldnews.adapter.NewsAdapter
import com.example.worldnews.data.local.NewsRepository
import com.example.worldnews.data.remote.ApiClient
import com.example.worldnews.databinding.FragmentHomeBinding
import com.example.worldnews.model.news.Article
import com.example.worldnews.model.news.New
import com.example.worldnews.utils.viewBinding
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding { FragmentHomeBinding.bind(it) }
    var list = ArrayList<Article>()
    lateinit var adapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        showProgress()
        getNews()
        binding.apply {
            adapter = NewsAdapter(list)
            adapter.shareClick ={ article ->
                findNavController().navigate(R.id.detailFragment, bundleOf(
                    "article" to Gson().toJson(article)
                ))
            }

            rvNews.adapter = adapter
            rvNews.layoutManager = GridLayoutManager(requireContext(), 1)
        }
    }

//    private fun forWebView(view: View) {
//        val ln_item=view.findViewById<LinearLayout>(R.id.ln_item)
//        ln_item.setOnClickListener {
//            val intent= Intent(this,DetailFragment::class.java)
//            startActivity(intent)
//        }
//
//    }


    private fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }

    private fun getNews() {
        ApiClient.apiService.getNews().enqueue(object : Callback<New> {
            override fun onResponse(call: Call<New>, response: Response<New>) {
                if (response.isSuccessful) {
                    Log.d("@@@@@", "onResponse: ${response.body()}")
                    list = response.body()!!.articles
                    adapter.submitList(list)
                    hideProgress()
                }
            }

            override fun onFailure(call: Call<New>, t: Throwable) {
                hideProgress()
            }

        })
    }


}


