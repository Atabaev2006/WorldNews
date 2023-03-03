package com.example.worldnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.worldnews.R
import com.example.worldnews.databinding.FragmentHomeBinding
import com.example.worldnews.utils.viewBinding


class HomeFragment : Fragment() {
    private val binding by viewBinding {FragmentHomeBinding.bind(it)}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {

    }

}