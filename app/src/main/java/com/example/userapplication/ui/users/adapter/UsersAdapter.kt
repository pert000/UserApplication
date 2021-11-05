package com.example.userapplication.ui.users.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userapplication.R
import com.example.userapplication.databinding.UserItemBinding
import com.example.userapplication.model.UserRespons
import com.example.userapplication.utils.ExtraKeys

class UsersAdapter(val context: Context,private var users: List<UserRespons>) :
    RecyclerView.Adapter< UsersAdapter.ViewHolder>() {

    fun setData(users: List<UserRespons>) {
        this.users = users
        notifyDataSetChanged()
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =users[position]
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



    class ViewHolder(val context: Context, private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserRespons) {

            binding.apply {
                title.text = item.name
                username.text = String.format("( %s )",item.owner?.login)
                Glide.with(context)
                    .load( item.owner?.avatar_url)
                    .into(icon)

                mainLayout.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putParcelable(ExtraKeys.REPOSITORY_INFO,item)
                    Navigation.findNavController(it)
                        .navigate(R.id.action_usersFragment_to_detailsFragment, bundle)

                }

            }

        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

}

