package com.example.userapplication.ui.users.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.databinding.UserItemBinding
import com.example.userapplication.model.UserRespons

class UsersAdapter(val context: Context) :
    PagingDataAdapter<UserRespons, UsersAdapter.ViewHolder>(DiffCallback()) {


    class ViewHolder(val context: Context, private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserRespons) {

            binding.apply {

            }

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            context,
            UserItemBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }


}

private class DiffCallback : DiffUtil.ItemCallback<UserRespons>() {
    override fun areItemsTheSame(oldItem: UserRespons, newItem: UserRespons): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserRespons, newItem: UserRespons): Boolean {
        return oldItem == newItem
    }
}