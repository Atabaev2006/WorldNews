package com.example.worldnews.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.worldnews.R
import com.example.worldnews.data.local.NewsRepository
import com.example.worldnews.databinding.FragmentDetailBinding
import com.example.worldnews.model.news.Article
import com.example.worldnews.utils.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson


class DetailFragment : Fragment(R.layout.fragment_detail) {

    lateinit var repository: NewsRepository
    private val binding by viewBinding { FragmentDetailBinding.bind(it) }
    private val gson = Gson()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val article = gson.fromJson(requireArguments().getString("article", ""), Article::class.java)
        Toast.makeText(requireContext(), article.description, Toast.LENGTH_SHORT).show()
        binding.wbView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }
        setupUI(article)
    }
    private fun setupUI(article: Article) {
        repository = NewsRepository(requireActivity().application)
        binding.apply {
            fbSave.setOnClickListener {
                Toast.makeText(requireContext(), "did you save that", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.saveFragment)
                repository.saveNews(article)
            }
        }

    }
}
