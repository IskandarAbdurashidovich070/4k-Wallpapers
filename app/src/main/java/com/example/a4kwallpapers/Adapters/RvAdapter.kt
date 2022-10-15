package com.example.a4kwallpapers.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a4kwallpapers.databinding.RvItemBinding
import com.example.a4kwallpapers.models.User
import com.example.a4kwallpapers.models.User1

class RvAdapter(var list: List<User1>, var click: Click): RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(val rvItemBinding: RvItemBinding) : RecyclerView.ViewHolder(rvItemBinding.root){
        fun onBind(user: User1){
            rvItemBinding.rvImage.setImageResource(user.image)
            rvItemBinding.rvImage.setOnClickListener{
                click.rvClick(user)


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface Click{
        fun rvClick(user:User1)
    }
}