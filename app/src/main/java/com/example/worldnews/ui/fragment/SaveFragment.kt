package com.example.worldnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.worldnews.R
import com.example.worldnews.adapter.SaveAdapter
import com.example.worldnews.data.local.NewsRepository
import com.example.worldnews.data.remote.ApiClient
import com.example.worldnews.databinding.FragmentSaveBinding
import com.example.worldnews.model.news.Article
import com.example.worldnews.model.news.New
import com.example.worldnews.utils.viewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SaveFragment : Fragment(R.layout.fragment_save) {
    lateinit var adapter: SaveAdapter
    lateinit var saveNews:ArrayList<Article>
    lateinit var repository: NewsRepository
    lateinit var list: ArrayList<Article>
   private val binding by viewBinding { FragmentSaveBinding.bind(it) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_save,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()

    }



    private fun setupUi() {
        binding.apply {
                repository = NewsRepository(requireActivity().application)
                saveNews = repository.getAllNews() as ArrayList
                list= repository.getAllNews()  as ArrayList<Article>
                adapter = SaveAdapter(list)
                loadNews("")
                val manager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                rvSave.adapter = adapter
                rvSave.layoutManager = manager
                adapter.detail = {
                    val bundle = Bundle()
                    bundle.putString("id", it)
                    bundle.putString("main", "save")
                    findNavController().navigate(R.id.action_detailFragment_to_saveFragment)
                }
        }
    }

    private fun loadNews(url: String) {
    }
}





















