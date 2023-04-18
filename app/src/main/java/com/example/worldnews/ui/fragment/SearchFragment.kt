package com.example.worldnews.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.room.util.query
import com.example.worldnews.R
import com.example.worldnews.adapter.SaveAdapter
import com.example.worldnews.adapter.SearchAdapter
import com.example.worldnews.data.local.NewsRepository
import com.example.worldnews.data.remote.ApiClient
import com.example.worldnews.databinding.FragmentSearchBinding
import com.example.worldnews.model.news.Article
import com.example.worldnews.model.news.ArticleX
import com.example.worldnews.model.news.Everything
import com.example.worldnews.model.news.New
import com.example.worldnews.utils.viewBinding
import com.google.android.material.internal.ViewUtils.hideKeyboard
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.worldnews.ui.fragment.SearchFragment as SearchFragment1

class SearchFragment : Fragment(R.layout.fragment_search) {
    lateinit var adapter: SearchAdapter
    var list = ArrayList<ArticleX>()
    lateinit var repository: NewsRepository
    private val binding by viewBinding { FragmentSearchBinding.bind(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi(view)
//        forSearchWeb()

    }

    private fun hideProgress() {
        binding.progressBarForSearch.visibility  = View.GONE
    }

    private fun showProgress() {
        binding.progressBarForSearch.visibility = View.VISIBLE
    }


//    private fun forSearchWeb() {
//        binding.apply {
//            adapter = SearchAdapter(list)
//            adapter.shareClick = {articleX ->
//                findNavController().navigate(R.id.detailFragment, bundleOf())
//                "article" to Gson().toJson(articleX)
//            }
//        }
//    }


    private fun setupUi(view: View) {
       binding.apply {
           etSearch.setOnKeyListener { _, keyCode, event ->
               if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                   hideKeyboard()
                   everything(etSearch.text.toString())
                    return@setOnKeyListener true
               }
               return@setOnKeyListener false
           }
           val manager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
            adapter = SearchAdapter(list)
            rvSearch?.adapter = adapter
           rvSearch?.layoutManager  = manager
             adapter.detail = {
                 val bundle = Bundle()
                 bundle.putString("id", it.toString())
                 bundle.putString("main", "search")
                 findNavController().navigate(R.id.action_searchFragment_to_detailFragment)

             }
       }
    }
    private fun everything(q: String) {
        showProgress()
       ApiClient.apiService.getAllNews(q).enqueue(object :Callback<Everything>{
           override fun onResponse(call: Call<Everything>, response: Response<Everything>) {
               if (response.isSuccessful){
                   list = response.body()!!.articles
                   adapter.submitList(list)
                   hideProgress()
               }


           }

           override fun onFailure(call: Call<Everything>, t: Throwable) {

           }


       })
    }
    private fun hideKeyboard() {
        val hide =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hide.hideSoftInputFromWindow(requireView().windowToken, 0)
    }




}