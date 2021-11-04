package com.example.userapplication.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.userapplication.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        init()

        return binding.root
    }
    private fun init() {


    }
    companion object {
        private lateinit var binding: FragmentDetailsBinding
    }
}