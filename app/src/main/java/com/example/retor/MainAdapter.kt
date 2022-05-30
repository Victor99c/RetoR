package com.example.retor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retor.database.User
import com.example.retor.databinding.ItemUserBinding


class MainAdapter (private val users: List<User>): RecyclerView.Adapter<MainAdapter.MainHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.render(users[position])
    }

    override fun getItemCount(): Int = users.size

    class MainHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){
        fun render(user: User){
            binding.etUsua.setText(user.user_name)
        }
    }
}