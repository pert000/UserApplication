package com.example.userapplication.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.R
import com.example.userapplication.databinding.FragmentUsersBinding
import com.example.userapplication.date.Resource
import com.example.userapplication.model.UserRespons
import com.example.userapplication.ui.users.adapter.UsersAdapter
import com.example.userapplication.ui.users.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class UsersFragment : Fragment() {
    private val viewModel: UsersViewModel by viewModels()
    lateinit var users: List<UserRespons>
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
        search()
        viewModel.usersRespons.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.LOADING -> {
                    binding.progress.progress.visibility =View.VISIBLE

                }
                Resource.Status.ERROR -> {
                    binding.progress.progress.visibility = View.GONE
                    Toast.makeText(context, getString(R.string.error_text), Toast.LENGTH_SHORT).show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progress.progress.visibility =View.GONE
                    users = it.data!!
                    adapter = UsersAdapter(requireContext(), it.data!!)
                    setupRecycler()

                }


            }

        }

    }

    private fun search() {
        binding.search.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText != null) {

                        adapter.setData( users.filter { it.name.toLowerCase().contains(newText.toLowerCase()) })
                        adapter.notifyDataSetChanged()
                    }
                    return false
                }
            }
        )

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