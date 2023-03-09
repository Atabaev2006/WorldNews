package com.example.worldnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.worldnews.R
import com.example.worldnews.databinding.FragmentSaveBinding
import com.example.worldnews.utils.viewBinding


class SaveFragment : Fragment(R.layout.fragment_save) {
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

    }

}