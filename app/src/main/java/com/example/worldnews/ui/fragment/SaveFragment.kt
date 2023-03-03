package com.example.worldnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.worldnews.R
import com.example.worldnews.databinding.FragmentSaveBinding


class SaveFragment : Fragment() {
     lateinit var binding: FragmentSaveBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding=FragmentSaveBinding.inflate(layoutInflater)
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {

        }
    }


}