package com.example.userapplication.ui.users

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.databinding.FragmentUsersBinding
import com.example.userapplication.date.Resource
import com.example.userapplication.ui.users.adapter.UsersAdapter
import com.example.userapplication.ui.users.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment() {
    private val viewModel: UsersViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(inflater, container, false);
        init()

        return binding.root
    }

    private fun init() {

        viewModel.getUsers()

        viewModel.usersRespons.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.ERROR -> {
                    //todo loader and error message
                }
                Resource.Status.SUCCESS -> {
                    adapter = UsersAdapter(requireContext(), it.data!!)
                    setupRecycler()
                }


            }

        }

    }



    private fun setupRecycler() {
        context?.apply {
            binding.recycler.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            binding.recycler.adapter = adapter
        }
    }


    companion object {
        private lateinit var binding: FragmentUsersBinding
        private lateinit var adapter: UsersAdapter

    }
}